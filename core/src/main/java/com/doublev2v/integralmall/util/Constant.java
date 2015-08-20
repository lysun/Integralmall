package com.doublev2v.integralmall.util;

import java.io.IOException;
import java.util.Properties;

public class Constant {
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(Constant.class.getClassLoader().getResourceAsStream("app.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 图片基础路径
	 */
	public static final String BASE_PATH = prop.getProperty("imageServer.basePath");
	/**
	 * 图片相对路径
	 */
	public static final String RELATIVE_PATH = prop.getProperty("imageServer.relativePath");
	/**
	 * rest远程请求地址
	 */
	public static final String REMOTE_PATH=prop.getProperty("remotePath");
	/**
	 * 商品是否是实物商品：否
	 */
	public static final String VIRTUAL="0";
	/**
	 * 商品是否是实物商品：是
	 */
	public static final String ACTUAL="1";
	/**
	 * 商品是否是下架：否
	 */
	public static final String SHELVE="1";
	/**
	 * 商品是否是下架：是
	 */
	public static final String UNSHELVE="0";
	
	/**
	 * 订单状态:(针对代金券):未使用
	 */
	public static final String UNUSED="00";
	/**
	 * 订单状态:(针对代金券):已使用
	 */
	public static final String USED="01";
	/**
	 * 订单状态:(针对实物)：待发货
	 */
	public static final String UNDELIVER="10";
	/**
	 * 订单状态:(针对实物)：已发货
	 */
	public static final String DELIVER="11";
	/**
	 * 订单状态:(针对实物)：已收货
	 */
	public static final String RECEIVING="12";
	/**
	 * 订单状态：已取消
	 */
	public static final String ORDER_CANCEL="20";
	/**
	 * 积分来源(扣除):兑换商品
	 */
	public static final String CONVERT_MERCHANDISE="兑换商品";
	/**
	 * 积分来源(增加):兑换商品取消
	 */
	public static final String CONVERT_MERCHANDISE_CANCEL="兑换商品取消";
	/**
	 * rest返回正确时的errmsg
	 */
	public static final String REST_MSG_OK="ok";
	/**
	 * rest返回正确时的errcode
	 */
	public static final String REST_CODE_OK="0";
	
	public static final String ROLE_ADMIN="ROLE_ADMIN";
	public static final String ROLE_ADD="ROLE_ADD";
	public static final String ROLE_VIEW="ROLE_VIEW";
}
