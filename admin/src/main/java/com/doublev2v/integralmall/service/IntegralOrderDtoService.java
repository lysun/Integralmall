package com.doublev2v.integralmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.converter.IntegralOrderDtoConverter;
import com.doublev2v.integralmall.entity.IntegralOrderDto;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.IntegralOrderService;
@Service
public class IntegralOrderDtoService extends AbstractDtoPagingService<IntegralOrder,IntegralOrderDto,String>{
	@Autowired
	private IntegralOrderDtoConverter dtoConverter;
	@Autowired
	private IntegralOrderService service;

	public PagedList<IntegralOrderDto> getList(Integer pageNo,Integer pageSize,
			String search,String startDate,String endDate,String orderBy,Direction seq){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		Page<IntegralOrder> list= service.findPage(page, null, search, startDate, endDate, orderBy, seq);
		Page<IntegralOrderDto> result=list.map(dtoConverter);
		return new PagedList<IntegralOrderDto>(result);
	}
}
