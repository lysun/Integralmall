package com.doublev2v.integralmall.util;

import com.doublev2v.foundation.core.rest.ErrorCode;

public class SystemErrorCodes {
	public static final ErrorCode SERVER_EXCEPTION;
	public static final ErrorCode NOTENOUGH_INTEGRAL;
	public static final ErrorCode NOTENOUGH_STOCK;
	public static final ErrorCode MERCHANDISE_DISABLED;
	public static final ErrorCode ORDER_CANNOT_CANCEL;
	public static final ErrorCode COUPONCODE_CANNOT_USE;
	static {
		/**
		 * 系统相关的异常，1**
		 */
		SERVER_EXCEPTION=new ErrorCode(100, "服务器异常，请稍后再试");
		/**
		 * 商品相关的异常，2**
		 */
		NOTENOUGH_INTEGRAL=new ErrorCode(200, "对不起，您的积分不足");
		NOTENOUGH_STOCK=new ErrorCode(201, "抱歉，库存不足");
		MERCHANDISE_DISABLED=new ErrorCode(202, "抱歉，商品已过期或已下架");
		/**
		 * 积分订单相关的异常，3**
		 */
		ORDER_CANNOT_CANCEL=new ErrorCode(300, "订单不能取消");
		COUPONCODE_CANNOT_USE=new ErrorCode(301, "抱歉，兑换码不可用");
	}
}

