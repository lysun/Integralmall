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
import com.doublev2v.foundation.dics.CategoryItemService;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;
import com.doublev2v.integralmall.util.Dics;
import com.doublev2v.integralmall.util.RequestResult;
@Controller
@RequestMapping("/admin/merchandise")
public class MerchandiseController extends CommonController<MerchandiseDto> {

	@Autowired
	private MerchandiseService service;
	@Autowired
	private CategoryItemService categoryItemService;
	
	@Override
	protected PagingService<MerchandiseDto, String> getService() {
		return service;
	}

	@Override
	protected String getBasePath() {
		return "admin/merchandise/";
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
			 @RequestParam(defaultValue="") String search,@RequestParam(required=false) String isActual,
			 @RequestParam(required=false)String orderBy, @RequestParam(required=false)Direction seq) {
		PagedList<MerchandiseDto> list=service.getList(page, size, isActual,search, orderBy, seq);
		return RequestResult.success(list).toJson();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"add";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("brands", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_BRAND_TYPE));
		view.addObject("classifies", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_CLASSIFY_TYPE));
		return view;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		String viewPath=getBasePath()+"edit";
		ModelAndView view=new ModelAndView(viewPath);
		MerchandiseDto t=getService().findOne(id);
		view.addObject("t", t);
		view.addObject("brands", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_BRAND_TYPE));
		view.addObject("classifies", categoryItemService.getCategoryItemsByType(Dics.MERCHANDISE_CLASSIFY_TYPE));
		return view;
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
