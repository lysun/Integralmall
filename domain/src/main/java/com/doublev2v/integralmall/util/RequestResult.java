package com.doublev2v.integralmall.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doublev2v.foundation.core.rest.ErrorCode;
import com.doublev2v.foundation.utils.JsonSerializer;
/**
 * 用于返回页面的数据格式
 * @author Administrator
 *
 */
public class RequestResult {

	private Object data;
	private String errcode;
	private String errmsg;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	private RequestResult(Object data, String errcode, String errmsg) {
		super();
		this.data = data;
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	public static RequestResult success(Object data){
		return new RequestResult(data,Constant.REST_CODE_OK,Constant.REST_MSG_OK);
	}
	public static RequestResult error(Object data,ErrorCode errcode,String errmsg){
		return new RequestResult(data,errcode.getCode().toString(),errmsg);
	}
	private static Logger logger=LoggerFactory.getLogger(RequestResult.class);
	public String toJson() {
		try {
			return JsonSerializer.Serialize(this);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
			return e.getMessage();
		}
	}
}
