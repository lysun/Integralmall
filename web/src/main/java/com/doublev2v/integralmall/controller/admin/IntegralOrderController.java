package com.doublev2v.integralmall.controller.admin;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.order.dto.IntegralOrderDto;
import com.doublev2v.integralmall.order.dto.IntegralOrderDtoService;
import com.doublev2v.integralmall.util.RequestResult;

@Controller
@RequestMapping("/admin/integralOrder")
public class IntegralOrderController extends CommonController<IntegralOrderDto>{

	@Autowired
	private IntegralOrderDtoService service;

	@Override
	protected PagingService<IntegralOrderDto, String> getService() {
		return service;
	}

	@Override
	protected String getBasePath() {
		return "admin/integralOrder/";
	}
	/**
	 * 获取积分订单列表
	 * @param page
	 * @param size
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @param orderBy
	 * @param seq
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/getlistdata",method=RequestMethod.GET)
	@ResponseBody
	public String integralOrders(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="12") Integer size,
			@RequestParam(required=false) String userId,@RequestParam(defaultValue="") String search,
			@RequestParam(required=false)String startDate, @RequestParam(required=false)String endDate, 
			@RequestParam(required=false)String orderBy, @RequestParam(required=false)Direction seq) throws ParseException {
		PagedList<IntegralOrderDto> list=service.getList(page, size, userId, search,startDate,endDate, orderBy, seq);
		return RequestResult.success(list).toJson();
	}
}
