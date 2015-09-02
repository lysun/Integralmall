package com.doublev2v.integralmall.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.foundation.dics.CategoryItemDtoService;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.coupon.CouponDto;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDtoService;
import com.doublev2v.integralmall.merchandise.gift.GiftDto;
import com.doublev2v.integralmall.shop.branch.BranchShopDtoService;
import com.doublev2v.integralmall.util.Dics;
import com.doublev2v.integralmall.util.RequestResult;
@Controller
@RequestMapping("/admin/merchandise")
public class MerchandiseController extends SimpleController<MerchandiseDto> {

	@Autowired
	private MerchandiseDtoService dtoService;
	@Autowired
	private MerchandiseService service;
	@Autowired
	private CategoryItemDtoService categoryItemService;
	@Autowired
	private BranchShopDtoService shopDtoService;

	@Override
	protected PagingService<MerchandiseDto, String> getService() {
		return dtoService;
	}

	@Override
	protected String getMenuTab() {
		return "merchandise";
	}
	/**
	 * 获取商品列表
	 * @param page
	 * @param size
	 * @param search
	 * @param isActual
	 * @param orderBy
	 * @param seq
	 * @return
	 */
	@RequestMapping(value="/getlistdata",method=RequestMethod.GET)
	@ResponseBody
	public String merchandises(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="12") Integer size,
			 @RequestParam(defaultValue="") String search,@RequestParam(required=false) String type,
			 @RequestParam(required=false)String orderBy, @RequestParam(required=false)Direction seq) {
		PagedList<MerchandiseDto> pageList=dtoService.getList(page, size, type,search, orderBy, seq);
		return RequestResult.success(pageList).toJson();
	}
	
	@RequestMapping(value="/{type}/add",method=RequestMethod.GET)
	public ModelAndView add(@PathVariable String type) {
		String viewPath=getBasePath()+type+"/add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("brands", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_BRAND_TYPE));
		view.addObject("classifies", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_CLASSIFY_TYPE));
		view.addObject("shops", shopDtoService.findAll());
		return view;
	}
	
	@RequestMapping(value="/{type}/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String type,@PathVariable String id) {
		String viewPath=getBasePath()+type+"/edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t",getService().findOne(id));
		view.addObject("brands", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_BRAND_TYPE));
		view.addObject("classifies", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_CLASSIFY_TYPE));
		view.addObject("shops", shopDtoService.findAll());
		return view;
	}
	@RequestMapping(value="/{type}/{id}",method=RequestMethod.GET)
	public ModelAndView info(@PathVariable String type,@PathVariable String id) {
		String viewPath=getBasePath()+type+"/info";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("top", getMenuService().getTopMenus());
		view.addObject("subMenu", getMenuService().getSecondMenus(getMenuTab()));
		view.addObject("t", getService().findOne(id));
		return view;
	}
	@RequestMapping(value="/coupon",method=RequestMethod.POST)
	public ModelAndView add(CouponDto t) {
		getService().add(t);
		return index();
	}
	@RequestMapping(value="/gift",method=RequestMethod.POST)
	public ModelAndView add(GiftDto t) {
		getService().add(t);
		return index();
	}
	@RequestMapping(value="/coupon/{id}",method=RequestMethod.POST)
	public ModelAndView edit(CouponDto t) {
		getService().update(t);
		return info("coupon",t.getId());
	}
	@RequestMapping(value="/gift/{id}",method=RequestMethod.POST)
	public ModelAndView edit(GiftDto t) {
		getService().update(t);
		return info("gift",t.getId());
	}
	
	/**
	 * 将商品下架
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/unshelve/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String unShelve(@PathVariable String id){
		service.unshelve(id);
		return RequestResult.success(null).toJson();
	}
	/**
	 * 删除商品的图片
	 * @param id
	 * @param mediaid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/delMedia",method=RequestMethod.GET)
	@ResponseBody
	public String delMedia(String id,String mediaid) throws IOException {
		service.deleteMedia(id, mediaid);
		return RequestResult.success(null).toJson();
		
	}
}
