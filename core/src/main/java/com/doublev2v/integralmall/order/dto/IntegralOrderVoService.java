package com.doublev2v.integralmall.order.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.service.AbstractDtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.IntegralOrderService;
@Service
public class IntegralOrderVoService extends AbstractDtoPagingService<IntegralOrder,IntegralOrderVO,String>{
	@Autowired
	private IntegralOrderVoConverter voConverter;
	@Autowired
	private IntegralOrderService service;
	
	public PagedList<IntegralOrderVO> getList(Integer pageNo,Integer pageSize,String userId){
		PageRequest page=new PageRequest(pageNo-1, pageSize);
		Page<IntegralOrder> list = service.getList(page, userId);
		List<IntegralOrderVO> listDetail=new ArrayList<IntegralOrderVO>();
		listDetail.addAll(voConverter.convertSimples(list.getContent()));//转换dto
		Page<IntegralOrderVO> result=new PageImpl<IntegralOrderVO>(listDetail,page,list.getTotalElements());
		return new PagedList<IntegralOrderVO>(result);
	}
}
