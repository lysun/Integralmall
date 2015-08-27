package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.TagService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("tagRestController")
public class TagController{
	@Autowired
	private TagService service;
	
	@RequestMapping(value="/tags",method=RequestMethod.GET)
	public String getTags(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer size){
		PagedList<Tag> list=service.findPage(page, size); 
		return RequestResult.success(list).toJson();
	}
}
