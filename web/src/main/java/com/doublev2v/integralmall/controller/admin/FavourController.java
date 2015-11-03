package com.doublev2v.integralmall.controller.admin;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.auth.menu.MenuService;
import com.doublev2v.integralmall.favour.CraftFavour;
import com.doublev2v.integralmall.favour.FavourMapper;
import com.doublev2v.integralmall.favour.UserFavour;
import com.doublev2v.integralmall.util.RequestResult;
import com.doublev2v.integralmall.util.RowBoundsBuilder;

@Controller
@RequestMapping("admin")
public class FavourController {

	@Autowired
	private FavourMapper mapper;
	@Autowired
	private MenuService service;
	
	@RequestMapping(value="favour/user",method=RequestMethod.GET)
	public ModelAndView userFavour() {
		ModelAndView view=new ModelAndView("admin/favour/user");
		view.addObject("top", service.getTopMenus());
		view.addObject("subMenu", service.getSecondMenus("favour"));
		return view;
	}
	@RequestMapping(value="favour/user/getdata",method=RequestMethod.GET)
	@ResponseBody
	public String userFavours() {
		List<UserFavour> list=mapper.userFavours(new RowBounds());
		return RequestResult.success(list).toJson();
	}
	@RequestMapping(value="favour/craft",method=RequestMethod.GET)
	public ModelAndView craftFavour() {
		ModelAndView view=new ModelAndView("admin/favour/craft");
		view.addObject("top", service.getTopMenus());
		view.addObject("subMenu", service.getSecondMenus("favour"));
		return view;
	}
	@RequestMapping(value="favour/craft/getdata",method=RequestMethod.GET)
	@ResponseBody
	public String craftFavours() {
		List<CraftFavour> list=mapper.craftFavours(new RowBounds());
		return RequestResult.success(list).toJson();
	}
}
