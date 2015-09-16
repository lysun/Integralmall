package com.doublev2v.integralmall.find.converter;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.converter.BranchShopDtoConverter;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.find.entity.IntegralOrderVo;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class IntegralOrderVoConverter extends SimpleDtoConverter<IntegralOrder, IntegralOrderVo> {

	@Autowired
	private BranchShopDtoConverter branchShopDtoConverter;
	
	@Override
	public IntegralOrderVo convert(IntegralOrder d) {
		IntegralOrderVo t=new IntegralOrderVo();
		t.setId(d.getId());
		t.setOrderDate(d.getOrderDate());
		t.setOrderNo(d.getOrderNo());
		t.setStatus(d.getStatus());
		OrderMerchandise om=d.getOrderMerchandise();
		if(om!=null){
			Merchandise m=om.getMerchandise();
			if(m!=null){
				t.setName(m.getName());
				if(m.getBrand()!=null){
					t.setBrandName(m.getBrand().getName());
				}
				if(m.getClassify()!=null){
					t.setClassifyName(m.getClassify().getName());
				}
				if(m.getMainPicMedia()!=null){
					t.setMainPic(m.getMainPicMedia().getUrl());
				}
				t.setRemark(m.getRemark());
				t.setUsageDate("");
				t.setCouponCode("");
				switch(m.getType()){
				case Constant.VIRTUAL:
					t.setType(Constant.VIRTUAL);
					if(m.getEndDate()!=null){
						t.setExpiryTime(DateUtil.format(m.getEndDate()).substring(0,10));
					}
					if(m.getShops()!=null){//将shopDto信息转过去用于比较哪个距离短
						Set<BranchShopDto> set=new HashSet<BranchShopDto>(branchShopDtoConverter.convertTs(m.getShops()));
						t.setShopDtos(set);
					}
					if(om.getUsageDate()!=null){
						t.setUsageDate(DateUtil.format(om.getUsageDate()));	
					}
					if(StringUtils.isNotBlank(om.getCouponCode())){
						t.setCouponCode(om.getCouponCode());
					}
					break;
				case Constant.ACTUAL:
					t.setType(Constant.ACTUAL);
					break;
				}
			}			
			
		}
		
		return t;
	}
	@Override
	public IntegralOrderVo convertSimple(IntegralOrder d) {
		IntegralOrderVo t=new IntegralOrderVo();
		t.setId(d.getId());
		t.setStatus(d.getStatus());
		OrderMerchandise om=d.getOrderMerchandise();
		if(om!=null){
			Merchandise m=om.getMerchandise();
			if(m!=null){
				t.setName(m.getName());
				if(m.getBrand()!=null){
					t.setBrandName(m.getBrand().getName());
				}
				if(m.getClassify()!=null){
					t.setClassifyName(m.getClassify().getName());
				}
				
				if(m.getMainPicMedia()!=null){
					t.setMainPic(m.getMainPicMedia().getUrl());
				}
				switch(m.getType()){
				case Constant.VIRTUAL:
					t.setType(Constant.VIRTUAL);
					if(m.getEndDate()!=null){
						t.setExpiryTime(DateUtil.format(m.getEndDate()).substring(0,10));
					}
					if(m.getShops()!=null){//将shopDto信息转过去用于比较哪个距离短
						Set<BranchShopDto> set=new HashSet<BranchShopDto>(branchShopDtoConverter.convertTs(m.getShops()));
						t.setShopDtos(set);
					}
					break;
				case Constant.ACTUAL:
					t.setType(Constant.ACTUAL);
					break;
				}
			}
		}
		
		return t;
	}

}
