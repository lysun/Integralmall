package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.core.service.LogicDeleteService;
import com.doublev2v.integralmall.util.RequestResult;


public abstract class LogicDeleteController<T extends Identified<String>> extends SimpleMenuController<T>{

	@Autowired
	private LogicDeleteService<T,String> service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable String id) {
		service.logicDelete(id);
		return RequestResult.success("删除成功").toJson();
	}
}
