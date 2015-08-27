package com.doublev2v.integralmall.merchandise.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.coupon.CouponVo;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
public class MerchandiseVoService extends AbstractDtoPagingService<Merchandise,MerchandiseVo,String>{
	@Autowired
	private MerchandiseVoConverter voConverter;
	@Autowired
	private MerchandiseService service;
	
	public PagedList<MerchandiseVo> getActual(Integer pageNo,Integer pageSize,String isActual){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		Page<Merchandise> list=service.findPage(page, isActual, null, null, null);
		List<MerchandiseVo> listDetail=
				new ArrayList<MerchandiseVo>(voConverter.convertSimples(list.getContent()));
		Page<MerchandiseVo> result=new PageImpl<MerchandiseVo>(listDetail,page,list.getTotalElements());
		return new PagedList<MerchandiseVo>(result);
	}
	
	public PagedList<MerchandiseVo> getVirtual(Integer pageNo,Integer pageSize,String isActual,
			String localAddress){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		Page<Merchandise> list=service.findPage(page, isActual, null, null, null);
		List<MerchandiseVo> listDto=
				new ArrayList<MerchandiseVo>(voConverter.convertSimples(list.getContent()));
		if(StringUtils.isNotBlank(localAddress)&&localAddress.matches("\\d+(\\.\\d+)?,\\d+(\\.\\d+)?")){
			String[] strs=localAddress.split(",");
			listDto.forEach((t)->((CouponVo)t).setDistance(((CouponVo)t)
					.calculateDistance(Double.valueOf(strs[0]), Double.valueOf(strs[1]))));//将每一个dto对象的distance计算出来并赋值
			Collections.sort(listDto,(a,b)->Double.compare(((CouponVo)a).getDistance(), ((CouponVo)b).getDistance()));//根据距离排序	
		}else
			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"所在位置参数格式不正确");
		Page<MerchandiseVo>  result=new PageImpl<MerchandiseVo>(listDto,page,list.getTotalElements());
		return new PagedList<MerchandiseVo>(result);
	}
}
