package com.doublev2v.integralmall.find.service;

import java.util.ArrayList;
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
import com.doublev2v.integralmall.find.converter.IntegralOrderVoConverter;
import com.doublev2v.integralmall.find.entity.IntegralOrderVo;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.IntegralOrderService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
public class IntegralOrderVoService extends AbstractDtoPagingService<IntegralOrder,IntegralOrderVo,String>{
	@Autowired
	private IntegralOrderVoConverter voConverter;
	@Autowired
	private IntegralOrderService service;
	
	public PagedList<IntegralOrderVo> getList(Integer pageNo,Integer pageSize,UserInfo user,String localAddress){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		Page<IntegralOrder> list = service.findPage(page, user, null, null, null, null, null);
		List<IntegralOrderVo> listDetail=new ArrayList<IntegralOrderVo>();
		listDetail.addAll(voConverter.convertSimples(list.getContent()));//转换dto
		if(StringUtils.isNotBlank(localAddress)&&localAddress.matches("\\d+(\\.\\d+)?,\\d+(\\.\\d+)?")){
			String[] strs=localAddress.split(",");
			listDetail.forEach((t)->t.calculateNearestBranchShop(Double.valueOf(strs[0]), Double.valueOf(strs[1])));
		}
//		else
//			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"所在位置参数格式不正确");
		Page<IntegralOrderVo> result=new PageImpl<IntegralOrderVo>(listDetail,page,list.getTotalElements());
		return new PagedList<IntegralOrderVo>(result);
	}
	
	public IntegralOrderVo findOne(String id,String localAddress) {
		IntegralOrderVo t=findOne(id);

		if(StringUtils.isNotBlank(localAddress)&&localAddress.matches("\\d+(\\.\\d+)?,\\d+(\\.\\d+)?")){
			String[] strs=localAddress.split(",");
			t.calculateNearestBranchShop(Double.valueOf(strs[0]), Double.valueOf(strs[1]));
		}
//		else
//			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"所在位置参数格式不正确");
		return t;
	}
	
}
