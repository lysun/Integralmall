package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.foundation.dics.CategoryItemDtoService;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.entity.ShopDto;
import com.doublev2v.integralmall.service.BranchShopDtoService;
import com.doublev2v.integralmall.service.ShopDtoService;
import com.doublev2v.integralmall.util.Dics;
import com.doublev2v.integralmall.util.RequestResult;

@Controller
@RequestMapping("/admin/shop")
public class ShopController extends LogicDeleteController<ShopDto> {
	
	@Autowired
	private ShopDtoService service;
	@Autowired
	private CategoryItemDtoService categoryItemDtoService;
	@Autowired
	private BranchShopDtoService branchShopDtoService;
	
	@Override
	protected PagingService<ShopDto, String> getService() {
		return service;
	}

	@Override
	protected String getMenuTab() {
		return "shop";
	}
	@RequestMapping(value="/getlistdata",method=RequestMethod.GET)
	@ResponseBody
	public String getlist(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="12") Integer size,
			String search) {
		return RequestResult.success(service.findPage(page, size, search)).toJson();
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("tags", categoryItemDtoService.getCategoryItemsByType(Dics.SHOP_CLASSIFY_TYPE));
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		return view;
	}
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		String viewPath=getBasePath()+"edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("t", getService().findOne(id));
		view.addObject("tags", categoryItemDtoService.getCategoryItemsByType(Dics.SHOP_CLASSIFY_TYPE));
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		return view;
	}
	@RequestMapping(value="/{id}/branch/add",method=RequestMethod.GET)
	public ModelAndView addbranch(@PathVariable String id) {
		String viewPath=getBasePath()+"branch/add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("shopId",id);
		return view;
	}
	
	@RequestMapping(value="/{shopId}/branch/{id}/edit",method=RequestMethod.GET)
	public ModelAndView editbranch(@PathVariable String id) {
		String viewPath=getBasePath()+"branch/edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("branch",branchShopDtoService.findOne(id));
		return view;
	}
	@RequestMapping(value="/{shopId}/branch",method=RequestMethod.POST)
	public ModelAndView addbranch(@PathVariable String shopId,BranchShopDto entity) {
		branchShopDtoService.add(entity);
		return index();
	}
	@RequestMapping(value="/{shopId}/branch/{id}",method=RequestMethod.POST)
	public String editbranch(@PathVariable String shopId,BranchShopDto entity) {
		branchShopDtoService.update(entity);
		return "redirect:/admin/shop/"+shopId+"/edit";
	}
	@RequestMapping(value="/{shopId}/branch/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deletebranch(@PathVariable String shopId,@PathVariable String id) {
		branchShopDtoService.logicDelete(id);
		return RequestResult.success(null).toJson();
	}
	/**
	 * 用于获取总店下的分店
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value="/getShop",method=RequestMethod.GET)
	@ResponseBody
	public String getShop(String shopId) {
		return RequestResult.success(service.findOne(shopId)).toJson();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable String id) {
		service.logicDelete(id);
		return RequestResult.success(null).toJson();
	}
}
