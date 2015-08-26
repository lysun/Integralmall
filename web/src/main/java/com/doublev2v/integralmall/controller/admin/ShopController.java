package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.foundation.dics.CategoryItemDtoService;
import com.doublev2v.integralmall.shop.ShopDtoService;
import com.doublev2v.integralmall.shop.dto.ShopDto;
import com.doublev2v.integralmall.tag.TagService;
import com.doublev2v.integralmall.util.Dics;

@Controller
@RequestMapping("/admin/shop")
public class ShopController extends CommonController<ShopDto> {
	
	@Autowired
	private ShopDtoService service;
	@Autowired
	private TagService tagService;
	@Autowired
	private CategoryItemDtoService categoryItemDtoService;
	@Override
	protected PagingService<ShopDto, String> getService() {
		return service;
	}

	@Override
	protected String getBasePath() {
		return "admin/shop/";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("classifies", categoryItemDtoService.getCategoryItemsByType(Dics.SHOP_CLASSIFY_TYPE));
		view.addObject("tags", tagService.findAll());
		return view;
	}
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		String viewPath=getBasePath()+"edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("t", getService().findOne(id));
		view.addObject("classifies", categoryItemDtoService.getCategoryItemsByType(Dics.SHOP_CLASSIFY_TYPE));
		view.addObject("tags", tagService.findAll());
		return view;
	}
	
}
