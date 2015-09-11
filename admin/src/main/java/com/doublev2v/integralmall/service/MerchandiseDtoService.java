package com.doublev2v.integralmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractPagingDtoService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.converter.MerchandiseDtoConverter;
import com.doublev2v.integralmall.entity.MerchandiseDto;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
@Service
public class MerchandiseDtoService extends AbstractPagingDtoService<Merchandise,MerchandiseDto,String>{
	@Autowired
	private MerchandiseDtoConverter dtoConverter;
	@Autowired
	private MerchandiseService service;

	public PagedList<MerchandiseDto> getList(Integer pageNo,Integer pageSize,String type,
			String search,String orderBy,Direction seq){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		Page<Merchandise> list = service.findPage(page, type, search, orderBy, seq);
		Page<MerchandiseDto> result=list.map(dtoConverter);
		return new PagedList<MerchandiseDto>(result);
	}
}
