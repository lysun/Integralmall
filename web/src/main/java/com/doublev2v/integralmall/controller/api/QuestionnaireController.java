package com.doublev2v.integralmall.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.questionnaire.QuestionNaire;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsService;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsVo;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireService;
import com.doublev2v.integralmall.userinfo.UserInfoRepository;
import com.doublev2v.integralmall.util.RequestResult;

@Controller
public class QuestionnaireController {
	
	@Autowired
	private QuestionNaireService questionNaireService;
	@Autowired
	private QuestionNaireItemsService itemService;
	@Autowired
	private UserInfoRepository userRepository;

	@RequestMapping(value="questionnaire/hasAnswered",method=RequestMethod.GET)
	public @ResponseBody String hasAnswered(String userId) {
		boolean hasAnswered=questionNaireService.hasAnswered(userId);
		Map<String, String> result=new HashMap<String, String>();
		result.put("hasAnswered", hasAnswered?"1":"0");
		return RequestResult.success(result).toJson();
	}
	
	@RequestMapping(value="user/couponses",method=RequestMethod.GET)
	public @ResponseBody String mycouponses(String userId) {
		Map<String, Object> result=new HashMap<>();
		if(questionNaireService.hasAnswered(userId)) {
			List<String> couponses=new ArrayList<String>();
			couponses.add("http://doublev2v.com/integralmall/resources/img/coupons.jpg");
			result.put("list", couponses);
			return RequestResult.success(result).toJson();
		} else {
			result.put("list", null);
			return RequestResult.success(result).toJson();
		}		
	}
	
	@RequestMapping(value="questionnaire",method=RequestMethod.GET)
	public ModelAndView questionnaire(@RequestParam String userId) {
		ModelAndView view=new ModelAndView("qn/ask");
		view.addObject("userId", userId);
		QuestionNaireItemsVo items=itemService.findOne(0L);
		view.addObject("items", items);
		return view;
	}
	
	@RequestMapping(value="questionnaire",method=RequestMethod.POST)
	public ModelAndView save(QuestionNaire qn) {
		boolean success=questionNaireService.save(qn);
		String page;		
		if(success) {
			page="qn/success";
		} else {
			page="qn/error";
		}
		ModelAndView view=new ModelAndView(page);
		return view;
	}
}
