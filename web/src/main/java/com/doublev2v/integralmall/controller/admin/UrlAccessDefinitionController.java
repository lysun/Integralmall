package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.auth.permission.UrlAccessDefinition;
import com.doublev2v.integralmall.auth.permission.UrlAccessDefinitionManager;
@Controller
@RequestMapping("/admin/url")
public class UrlAccessDefinitionController extends SimpleController<UrlAccessDefinition> {

	@Autowired
	private UrlAccessDefinitionManager service;
	
	@Override
	protected String getMenuTab() {
		// TODO Auto-generated method stub
		return "url";
	}

	@Override
	protected PagingService<UrlAccessDefinition, String> getService() {
		// TODO Auto-generated method stub
		return service;
	}

}
