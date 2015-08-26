package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.TagService;
import com.doublev2v.integralmall.tag.shop.ShopTag;

@Controller
@RequestMapping("/admin/tag")
public class TagController extends CommonController<Tag> {
	@Autowired
	private TagService service;
	@Override
	protected PagingService<Tag, String> getService() {
		return service;
	}

	@Override
	protected String getBasePath() {
		return "admin/tag/";
	}
	@RequestMapping(value="/shop/{id}",method=RequestMethod.POST)
	public ModelAndView edit(ShopTag t) {
		getService().update(t);
		return info(t.getId());
	}
	
	/**
	 * 添加资源
	 * @param t
	 * @return
	 */
	@RequestMapping(value="/shop",method=RequestMethod.POST)
	public ModelAndView add(ShopTag t) {
		getService().add(t);
		return index();
	}
}
