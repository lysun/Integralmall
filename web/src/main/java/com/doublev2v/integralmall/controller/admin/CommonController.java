package com.doublev2v.integralmall.controller.admin;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.util.RequestResult;


public abstract class CommonController<T extends Identified<String>> {
	/**
	 * 
	 * @return
	 */
	protected abstract PagingService<T, String> getService();
	/**
	 * jsp页面基础路径，结尾带/
	 * @return
	 */
	protected abstract String getBasePath();
	/**
	 * 获取资源列表
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView index() {
		String viewPath=getBasePath()+"index";
		ModelAndView view=new ModelAndView(viewPath);
		return view;
	}
	
	@RequestMapping(value="/getlist",method=RequestMethod.GET)
	@ResponseBody
	public String getlist(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="12") Integer size) {
		return RequestResult.success(getService().findPage(page, size)).toJson();
	}
	
	/**
	 * 获取添加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
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
		return view;
	}
	
	/**
	 * 删除资源
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable String id) {
		getService().delete(id);
		return RequestResult.success(null).toJson();
	}
	
	/**
	 * 修改资源
	 * @param id 会和其它参数一样自动注入t中
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public ModelAndView edit(T t) {
		getService().update(t);
		return info(t.getId());
	}
	
	/**
	 * 添加资源
	 * @param t
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.POST)
	public ModelAndView add(T t) {
		getService().add(t);
		return index();
	}

}
