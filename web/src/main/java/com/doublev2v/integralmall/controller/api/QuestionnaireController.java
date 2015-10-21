package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsService;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsVo;
import com.doublev2v.integralmall.util.RequestResult;

@RestController
public class QuestionnaireController {
	
	@Autowired
	private QuestionNaireItemsService itemsService;

	@RequestMapping(value="questionnaire",method=RequestMethod.GET)
	public String questionnaire() {
		QuestionNaireItemsVo result=itemsService.findOne(0L);
		return RequestResult.success(result).toJson();
	}
}
