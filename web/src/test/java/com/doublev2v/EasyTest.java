package com.doublev2v;

import com.doublev2v.integralmall.integral.detail.IntegralOrigin;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.MapPointDistance;

public class EasyTest {

	public static void main(String[] args) {
		double d=MapPointDistance.getPointsDistance(116.509922,39.925419,116.515786,39.925590);
		System.out.println(d);//500m
		
		IntegralOrder order = new IntegralOrder();
		OrderMerchandise om=new OrderMerchandise();
		order.setOrderMerchandise(om);
		order=setValue(order);
		System.out.println(order.getStatus());
		System.out.println(order.getOrderMerchandise().getCouponCode());
		System.out.println(IntegralOrigin.BUY_MERCHANDISE.ordinal());
	}
	public static IntegralOrder setValue(IntegralOrder order){
		order.setStatus(Constant.ORDER_CANCEL);
		order.getOrderMerchandise().setCouponCode("123");
		return order;
	}
}
