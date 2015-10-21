package com.doublev2v.integralmall.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.designerCraft.DesignerCraftService;
import com.doublev2v.integralmall.util.RequestResult;

@RestController("designerCraftController")
public class DesignerCraftController{
	
	@Autowired
	private DesignerCraftService service;
	
	@RequestMapping(value="/getDesignerCraftsByIds",method=RequestMethod.GET)
	public String getDesignerCrafts(String ids){
		List<String> list=new ArrayList<String>();
		for(String id:ids.split(",")){
			list.add(id);
		}
		return RequestResult.success(service.findAll(list)).toJson();
	}
}
