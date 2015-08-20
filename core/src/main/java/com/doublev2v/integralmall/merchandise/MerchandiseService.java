package com.doublev2v.integralmall.merchandise;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class MerchandiseService extends AbstractPagingAndSortingService<Merchandise,String>{
	@Autowired
	private MerchandiseRepository repository;
	@Autowired
	private MediaService mediaService;
	/**
	 * 根据条件返回上架商品列表
	 * @param page
	 * @param isActual
	 * @param search
	 * @param orderBy
	 * @param seq
	 * @return
	 */
	public Page<Merchandise> findPage(Pageable page,String isActual,
			String search,String orderBy,Direction seq){
		if(StringUtils.isNotBlank(orderBy)){
			page=new PageRequest(page.getPageNumber(), page.getPageSize(),new Sort(seq,orderBy));
		}
		return repository.findAll(getQueryClause(isActual,search), page);
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
		Merchandise d=findOne(id);
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
                
                if(StringUtils.isNotBlank(isActual)){
                	predicate.add(cb.equal(root.get("isActual").as(String.class), isActual));
                }
                predicate.add(cb.equal(root.get("isShelve").as(String.class), Constant.SHELVE));
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
