package com.doublev2v.integralmall.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.designerCraft.DesignerMapper;
import com.doublev2v.integralmall.util.RequestResult;

@RestController("designerCraftController")
public class DesignerCraftController{
	
	@Autowired
	private DesignerMapper mapper;
	
	@RequestMapping(value="/getDesignerCraftsByIds",method=RequestMethod.GET)
	public String getDesignerCrafts(String ids, String userid){
		List<String> list=new ArrayList<String>();
		for(String id:ids.split(",")){
			list.add(id);
		}
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("list", mapper.findCrafts(list,userid));
		return RequestResult.success(result).toJson();
	}
}
