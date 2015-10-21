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
	public static final String REMOTE_PATH=prop.getProperty("JefenImageServer.address");
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
	 * rest返回正确时的errmsg
	 */
	public static final String REST_MSG_OK="ok";
	/**
	 * rest返回正确时的errcode
	 */
	public static final String REST_CODE_OK="0";
	
	/**
	 * 数据库中的角色定义
	 */
	public static final String ROLE_SHOP_USER="ROLE_SHOP";
	public static final String ROLE_BRANCH_SHOP_USER="ROLE_BRANCH";
}
