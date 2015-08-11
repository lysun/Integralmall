package com.doublev2v.integralmall.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.util.RequestResult;
import com.doublev2v.integralmall.util.SystemErrorCodes;
/**
 * 用于处理controller的异常，子类直接继承
 * @author Administrator
 *
 */
@ControllerAdvice
@ResponseBody
public class ApiExceptionHandlerAdvice{
	@ExceptionHandler(Exception.class)
	public String execute(HttpServletRequest request , Exception ex) {
		Logger logger = LogManager.getLogger(CommonController.class);
		logger.error(ex.getMessage(),ex);
		if(ex instanceof ErrorCodeException){
			ErrorCodeException eex=(ErrorCodeException)ex;
			return RequestResult.error(null,eex.getErrorCode(),eex.getMessage()).toJson();
		}
		return RequestResult.error(null,SystemErrorCodes.SERVER_EXCEPTION, SystemErrorCodes.SERVER_EXCEPTION.getError()).toJson();

	}
	
	

}