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
import com.doublev2v.integralmall.auth.role.RoleDtoService;
import com.doublev2v.integralmall.auth.role.dto.RoleDto;

@Controller
@RequestMapping("/admin/role")
public class RoleController extends SimpleController<RoleDto> {
	
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
	@RequestMapping(value="/menu/add",method=RequestMethod.GET)
	public ModelAndView addMenu() {
		String viewPath=getBasePath()+"menu/add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("menus", menuService.findAll());
		return view;
	}
	@RequestMapping(value="/perm/add",method=RequestMethod.GET)
	public ModelAndView addPerm() {
		String viewPath=getBasePath()+"perm/add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("perms", permissionService.findAll());
		return view;
	}
	@RequestMapping(value="/menu/{id}/edit",method=RequestMethod.GET)
	public ModelAndView editMenu(@PathVariable String id) {
		String viewPath=getBasePath()+"menu/edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t", service.findOne(id));
		view.addObject("menus", menuService.findAll());
		return view;
	}
	@RequestMapping(value="/perm/{id}/edit",method=RequestMethod.GET)
	public ModelAndView editPerm(@PathVariable String id) {
		String viewPath=getBasePath()+"perm/edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t", service.findOne(id));
		view.addObject("perms", permissionService.findAll());
		return view;
	}
	@RequestMapping(value="/menu/{id}",method=RequestMethod.GET)
	public ModelAndView infoMenu(@PathVariable String id) {
		String viewPath=getBasePath()+"menu/info";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t", service.findOne(id));
		return view;
	}
	@RequestMapping(value="/perm/{id}",method=RequestMethod.GET)
	public ModelAndView infoPerm(@PathVariable String id) {
		String viewPath=getBasePath()+"perm/info";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t", service.findOne(id));
		return view;
	}

	@RequestMapping(value="/menu/{id}",method=RequestMethod.POST)
	public ModelAndView editPost(RoleDto t) {
		getService().update(t);
		return infoMenu(t.getId());
	}
	@RequestMapping(value="/perm/{id}",method=RequestMethod.POST)
	public ModelAndView edit(RoleDto t) {
		getService().update(t);
		return infoPerm(t.getId());
	}
}
