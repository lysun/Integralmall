package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.auth.menu.MenuService;
/**
 * 添加显示菜单的公共方法
 * @author Administrator
 *
 */
public abstract class SimpleController<T extends Identified<String>> extends CommonController<T> {
	@Autowired
	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	protected abstract String getMenuTab();
	
	protected String getBasePath(){
		return "admin/"+getMenuTab()+"/";
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView index() {
		String viewPath=getBasePath()+"index";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		return view;
	}
	/**
	 * 获取添加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		return view;
	}
	
	/**
	 * 获取查询页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView info(@PathVariable String id) {
		String viewPath=getBasePath()+"info";
		ModelAndView view=new ModelAndView(viewPath);
		T t=getService().findOne(id);
		view.addObject("t", t);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		return view;
	}
	
	/**
	 * 获取编辑页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		String viewPath=getBasePath()+"edit";
		ModelAndView view=new ModelAndView(viewPath);
		T t=getService().findOne(id);
		view.addObject("t", t);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		return view;
	}
	
}
