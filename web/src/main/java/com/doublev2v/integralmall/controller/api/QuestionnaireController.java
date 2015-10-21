package com.doublev2v.integralmall.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.questionnaire.QuestionNaire;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsService;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsVo;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireService;
import com.doublev2v.integralmall.util.RequestResult;

@Controller
public class QuestionnaireController {
	
	@Autowired
	private QuestionNaireService questionNaireService;
	@Autowired
	private QuestionNaireItemsService itemService;

	@RequestMapping(value="questionnaire/hasAnswered",method=RequestMethod.GET)
	public @ResponseBody String hasAnswered(String userId) {
		boolean hasAnswered=questionNaireService.hasAnswered(userId);
		Map<String, Boolean> result=new HashMap<String, Boolean>();
		result.put("hasAnswered", hasAnswered);
		return RequestResult.success(result).toJson();
	}
	
	@RequestMapping(value="questionnaire",method=RequestMethod.GET)
	public ModelAndView questionnaire(String userId) {
		ModelAndView view=new ModelAndView("qn/ask");
		view.addObject("userId", userId);
		QuestionNaireItemsVo items=itemService.findOne(0L);
		view.addObject("items", items);
		return view;
	}
	
	@RequestMapping(value="questionnaire",method=RequestMethod.POST)
	public ModelAndView questionnaire(QuestionNaire qn) {
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
