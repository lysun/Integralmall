package com.doublev2v.integralmall.order.dto;

import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleAbstractDtoAdater;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.OrderMerchandise;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class IntegralOrderDetailAdapter extends SimpleAbstractDtoAdater<IntegralOrder, IntegralOrderDetail> {

	@Override
	public IntegralOrderDetail convert(IntegralOrder d) {
		IntegralOrderDetail t=new IntegralOrderDetail();
		t.setId(d.getId());
		t.setOrderDate(d.getOrderDate());
		t.setOrderNo(d.getOrderNo());
		t.setStatus(d.getStatus());
		OrderMerchandise om=d.getOrderMerchandise();
		if(om!=null){
			Merchandise m=om.getMerchandise();
			if(m!=null){
				t.setName(m.getName());
				t.setIsActual(m.getIsActual());
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
				//代金券特有信息
				if(Constant.VIRTUAL.equals(m.getIsActual())){
					if(om.getExpiryDate()!=null){
						t.setExpiryTime(om.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
					}
					t.setAddress(m.getAddress());
					t.setShopName(m.getShopName());
					t.setLongitude(m.getLongitude());
					t.setLatitude(m.getLatitude());
					if(om.getUsageDate()!=null){
						t.setUsageDate(DateUtil.format(om.getUsageDate()));	
					}
					if(StringUtils.isNotBlank(om.getCouponCode())){
						t.setCouponCode(om.getCouponCode());
					}
				}
			}			
			
		}
		
		return t;
	}
	@Override
	public IntegralOrderDetail convertSimple(IntegralOrder d) {
		IntegralOrderDetail t=new IntegralOrderDetail();
		t.setId(d.getId());
		t.setStatus(d.getStatus());
		OrderMerchandise om=d.getOrderMerchandise();
		if(om!=null){
			Merchandise m=om.getMerchandise();
			if(m!=null){
				t.setName(m.getName());
				t.setIsActual(m.getIsActual());
				if(m.getBrand()!=null){
					t.setBrandName(m.getBrand().getName());
				}
				if(m.getClassify()!=null){
					t.setClassifyName(m.getClassify().getName());
				}
				t.setIsActual(m.getIsActual());
				if(m.getMainPicMedia()!=null){
					t.setMainPic(m.getMainPicMedia().getUrl());
				}
				if(Constant.VIRTUAL.equals(m.getIsActual())){
					if(om.getExpiryDate()!=null){
						t.setExpiryTime(om.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
					}
					t.setAddress(m.getAddress());
					t.setShopName(m.getShopName());
					t.setLongitude(m.getLongitude());
					t.setLatitude(m.getLatitude());
				}
			}
		}
		
		return t;
	}

}
