package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.permission.PermissionService;

@Controller
@RequestMapping("/admin/perm")
public class PermissionController extends CommonController<Permission> {
	
	@Autowired
	private PermissionService service;
	
	@Override
	protected PagingService<Permission, String> getService() {
		return service;
	}

	@Override
	protected String getBasePath() {
		return "admin/perm/";
	}
	
	
}
