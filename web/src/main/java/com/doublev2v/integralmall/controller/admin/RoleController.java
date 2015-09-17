package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.auth.menu.MenuService;
import com.doublev2v.integralmall.auth.permission.PermissionService;
import com.doublev2v.integralmall.entity.RoleDto;
import com.doublev2v.integralmall.service.RoleDtoService;

@Controller
@RequestMapping("/admin/role")
public class RoleController extends SimpleMenuController<RoleDto> {
	
	@Autowired
	private RoleDtoService service;
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private MenuService menuService;
	
	@Override
	protected PagingService<RoleDto, String> getService() {
		return service;
	}

	@Override
	protected String getMenuTab() {
		return "role";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("perms", menuService.findAll());
		return view;
	}

	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		String viewPath=getBasePath()+"edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t", service.findOne(id));
		view.addObject("perms", permissionService.findAll());
		return view;
	}
	
}
