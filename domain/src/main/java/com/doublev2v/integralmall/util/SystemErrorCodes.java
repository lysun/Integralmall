package com.doublev2v.integralmall.util;

import com.doublev2v.foundation.core.rest.ErrorCode;
/**
 * 异常类型的定义
 * @author Administrator
 *
 */
public class SystemErrorCodes {
	public static final ErrorCode SERVER_EXCEPTION;
	public static final ErrorCode UNLOGIN;
	public static final ErrorCode IIIEGAL_ARGUMENT;
	public static final ErrorCode NOUSER;
	public static final ErrorCode NOTENOUGH_INTEGRAL;
	public static final ErrorCode NOTENOUGH_STOCK;
	public static final ErrorCode MERCHANDISE_UNSTART;
	public static final ErrorCode MERCHANDISE_EXPIRE;
	public static final ErrorCode MERCHANDISE_UNSHELVE;
	public static final ErrorCode ORDER_CANNOT_CANCEL;
	public static final ErrorCode COUPONCODE_CANNOT_USE;
	public static final ErrorCode REMOTE_DATA_ERROR;
	public static final ErrorCode REMOTE_DATA_PARSE_ERROR;
	public static final ErrorCode BRANCHSHOP_HAS_MERCHS;
	public static final ErrorCode ACCOUNT_HAS_INTEGRAL;
	public static final ErrorCode NONE_ACCOUNT;
	static {
		/**
		 * 系统相关的异常，1**
		 */
		SERVER_EXCEPTION=new ErrorCode(100, "服务器异常，请稍后再试");
		UNLOGIN=new ErrorCode(101, "用户未登录");
		IIIEGAL_ARGUMENT=new ErrorCode(102, "传入的参数不正确");
		NOUSER=new ErrorCode(103, "该用户不存在");
		/**
		 * 商品相关的异常，2**
		 */
		NOTENOUGH_STOCK=new ErrorCode(200, "抱歉，库存不足");
		MERCHANDISE_UNSTART=new ErrorCode(201, "抱歉，商品活动未开始");
		MERCHANDISE_EXPIRE=new ErrorCode(202, "抱歉，商品已过期");
		MERCHANDISE_UNSHELVE=new ErrorCode(203, "抱歉，商品已下架");
		/**
		 * 积分订单相关的异常，3**
		 */
		ORDER_CANNOT_CANCEL=new ErrorCode(300, "订单不能取消");
		COUPONCODE_CANNOT_USE=new ErrorCode(301, "抱歉，兑换码不可用");
		/**
		 * 调用远程接口相关异常，4**
		 */
		REMOTE_DATA_ERROR=new ErrorCode(400, "数据错误");
		REMOTE_DATA_PARSE_ERROR=new ErrorCode(401, "数据解析错误");
		/**
		 * 商户相关的异常，5**
		 */
		BRANCHSHOP_HAS_MERCHS=new ErrorCode(501, "分店有上架的商品，不能删除");
		/**
		 * 积分相关的异常，6**
		 */
		NONE_ACCOUNT=new ErrorCode(600, "该账户不存在");
		ACCOUNT_HAS_INTEGRAL=new ErrorCode(600, "该账户已经存在积分信息");
		NOTENOUGH_INTEGRAL=new ErrorCode(601, "对不起，您的积分不足");
	}
}

