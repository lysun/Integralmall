package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.auth.permission.PermissionService;
import com.doublev2v.integralmall.auth.role.RoleDtoService;
import com.doublev2v.integralmall.auth.role.dto.RoleDto;

@Controller
@RequestMapping("/admin/role")
public class RoleController extends CommonController<RoleDto> {
	
	@Autowired
	private RoleDtoService service;
	
	@Autowired
	private PermissionService permissionService;
	
	@Override
	protected PagingService<RoleDto, String> getService() {
		return service;
	}

	@Override
	protected String getBasePath() {
		return "admin/role/";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("perms", permissionService.findAll());
		return view;
	}
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		String viewPath=getBasePath()+"edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("t", service.findOne(id));
		view.addObject("perms", permissionService.findAll());
		return view;
	}

}
