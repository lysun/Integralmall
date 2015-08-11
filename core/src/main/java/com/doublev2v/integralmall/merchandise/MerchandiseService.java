package com.doublev2v.integralmall.merchandise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.DtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDetail;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDetailAdapter;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDtoAdapter;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class MerchandiseService extends DtoPagingService<Merchandise,MerchandiseDto,String>{

	@Autowired
	private MerchandiseRepository repository;
	@Autowired
	private MediaService mediaService;
	@Autowired
	private MerchandiseDtoAdapter adapter;
	@Autowired
	private MerchandiseDetailAdapter detailAdapter;
	/**
	 * 根据条件返回上架商品列表
	 * @param pageNo
	 * @param pageSize
	 * @param search
	 * @param orderBy
	 * @param seq
	 * @return
	 */
	public PagedList<MerchandiseDto> getList(Integer pageNo,Integer pageSize,String isActual,
			String search,String orderBy,Direction seq){
		PageRequest page=new PageRequest(pageNo-1, pageSize);
		if(orderBy!=null){
			page=new PageRequest(pageNo-1, pageSize,new Sort(seq,orderBy));
		}
		Page<Merchandise> list = repository.findAll(getQueryClause(isActual,search), page);
		Page<MerchandiseDto> result=list.map(adapter);
		return new PagedList<MerchandiseDto>(result);
	}

	/**
	 * 返回前端需要的实物商品
	 * @param pageNo
	 * @param pageSize
	 * @param isActual
	 * @return
	 */
	public PagedList<MerchandiseDetail> getMerchandiseDetails(Integer pageNo,Integer pageSize,
			String isActual){
		PageRequest page=new PageRequest(pageNo-1, pageSize);
		Page<Merchandise> list=repository.findAll(getQueryClause(isActual,null),page);
		List<MerchandiseDetail> listDetail=
				new ArrayList<MerchandiseDetail>(detailAdapter.convertSimpleList(list.getContent()));
		Page<MerchandiseDetail> result=new PageImpl<MerchandiseDetail>(listDetail,page,list.getTotalElements());
		return new PagedList<MerchandiseDetail>(result);
	}
	/**
	 * 返回前端需要的附近商家
	 * @param pageNo
	 * @param pageSize
	 * @param localAddress
	 * @return
	 */
	public PagedList<MerchandiseDetail> getNearByMerchandises(Integer pageNo,Integer pageSize,
			String localAddress){
		PageRequest page=new PageRequest(pageNo-1, pageSize);
		Page<Merchandise> list=repository.findAll(getQueryClause(Constant.VIRTUAL,null),page);
		List<MerchandiseDetail> listDto=
				new ArrayList<MerchandiseDetail>(detailAdapter.convertSimpleList(list.getContent()));
		if(StringUtils.isNotBlank(localAddress)){
			double lng_a=Double.valueOf(localAddress.split(",")[0]);
			double lat_a=Double.valueOf(localAddress.split(",")[1]);
			listDto.forEach((t)->t.setDistance(t.calculateDistance(lng_a, lat_a)));//将每一个dto对象的distance计算出来并赋值
			Collections.sort(listDto,(a,b)->Double.compare(a.getDistance(), b.getDistance()));//根据距离排序
		}
		Page<MerchandiseDetail>  result=new PageImpl<MerchandiseDetail>(listDto,page,list.getTotalElements());
		return new PagedList<MerchandiseDetail>(result);
	}

	/**
	 * 修改库存
	 */
	public Merchandise updateStock(String id,int count){
		Merchandise merchandise=repository.findOne(id);
		if(merchandise.getStock()<count)
			throw new ErrorCodeException(SystemErrorCodes.NOTENOUGH_STOCK,"库存不足");
		merchandise.setStock(merchandise.getStock()-count);
		return repository.save(merchandise);
	}
	
	/**
	 * 将商品下架
	 */
	public Merchandise unshelve(String id){
		Merchandise merchandise=repository.findOne(id);
		merchandise.setIsShelve(Constant.UNSHELVE);
		return repository.save(merchandise);
	}
	/**
	 * 删除商品中的图片
	 * @param designerid
	 * @param mediaid
	 * @return
	 * @throws IOException 
	 */
	public Merchandise deleteMedia(String id,String mediaid) throws IOException {
		Merchandise d=getDo(id);
		Set<MediaContent> medias=d.getMedias();
		for(MediaContent media:medias){
			if(media.getId().equals(mediaid)){
				medias.remove(media);
				break;
			}
		}
		d.setMedias(medias);
		repository.save(d);
		mediaService.delete(mediaid);
		return d;
	}
	public Merchandise getDo(String id){
		return repository.findOne(id);
	}
	
	public MerchandiseDetail getMerchandiseDetail(String id){
		return detailAdapter.convert(getDo(id));
	}
	/**
	 * 返回查询条件Specification
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Specification<Merchandise> getQueryClause(String isActual,String search){
        return new Specification<Merchandise>() {
            @Override
            public Predicate toPredicate(Root<Merchandise> root, CriteriaQuery<?> query,
            		CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                predicate.add(cb.equal(root.get("isShelve").as(String.class), Constant.SHELVE));
                if(StringUtils.isNotBlank(isActual)){
                	predicate.add(cb.equal(root.get("isActual").as(String.class), isActual));
    			}
                if(StringUtils.isNotBlank(search)){
                	predicate.add(cb.like(root.get("name").as(String.class), "%" + search + "%"));
                }
                Predicate[] pre = new Predicate[predicate.size()];
                query.where(predicate.toArray(pre));//将where字句给query
                query.orderBy(cb.desc(root.get("createTime")));//默认按创建日期排序
                return query.getRestriction();
            }
        };
    }
}
