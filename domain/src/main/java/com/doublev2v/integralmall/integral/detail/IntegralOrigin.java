package com.doublev2v.integralmall.integral.detail;

public enum IntegralOrigin {

	/**
	 *积分来源(增加)： 购买商品
	 */
	BUY_MERCHANDISE,
	/**
	 * 积分来源(扣减)：兑换商品
	 */
	CONVERT_MERCHANDISE,
	/**
	 * 积分来源(增加)：兑换商品取消
	 */
	CONVERT_MERCHANDISE_CANCEL;
	
	/**
	 * 根据ordinal获取enum里定义的对象
	 * @param ordinal
	 * @return
	 */
	public static IntegralOrigin get(int ordinal){
		return IntegralOrigin.values()[ordinal];
	}
}


