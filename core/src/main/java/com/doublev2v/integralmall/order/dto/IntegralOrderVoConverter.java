package com.doublev2v.integralmall.order.dto;

import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleDtoConverter;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.coupon.Coupon;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class IntegralOrderVoConverter extends SimpleDtoConverter<IntegralOrder, IntegralOrderVO> {

	@Override
	public IntegralOrderVO convert(IntegralOrder d) {
		IntegralOrderVO t=new IntegralOrderVO();
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
				t.setUsageDate("");
				t.setCouponCode("");
				switch(m.getIsActual()){
				case Constant.VIRTUAL:
					t.setIsActual(Constant.VIRTUAL);
					Coupon c=(Coupon)m;
					if(om.getExpiryDate()!=null){
						t.setExpiryTime(om.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
					}
					t.setAddress(c.getAddress());
					t.setShopName(c.getShopName());
					t.setLongitude(c.getLongitude());
					t.setLatitude(c.getLatitude());
					if(om.getUsageDate()!=null){
						t.setUsageDate(DateUtil.format(om.getUsageDate()));	
					}
					if(StringUtils.isNotBlank(om.getCouponCode())){
						t.setCouponCode(om.getCouponCode());
					}
					break;
				case Constant.ACTUAL:
					t.setIsActual(Constant.ACTUAL);
					break;
				}
			}			
			
		}
		
		return t;
	}
	@Override
	public IntegralOrderVO convertSimple(IntegralOrder d) {
		IntegralOrderVO t=new IntegralOrderVO();
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
				switch(m.getIsActual()){
				case Constant.VIRTUAL:
					t.setIsActual(Constant.VIRTUAL);
					Coupon c=(Coupon)m;
					if(om.getExpiryDate()!=null){
						t.setExpiryTime(om.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
					}
					t.setAddress(c.getAddress());
					t.setShopName(c.getShopName());
					t.setLongitude(c.getLongitude());
					t.setLatitude(c.getLatitude());
					break;
				case Constant.ACTUAL:
					t.setIsActual(Constant.ACTUAL);
					break;
				}
			}
		}
		
		return t;
	}

}
