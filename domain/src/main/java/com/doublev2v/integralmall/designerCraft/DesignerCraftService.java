package com.doublev2v.integralmall.designerCraft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.util.Constant;
@Service
@Transactional
public class DesignerCraftService extends AbstractPagingAndSortingService<DesignerCraft, String>{
	
	@Autowired
	private DesignerCraftRepository designerCraftRepository;
	@Override
	public Iterable<DesignerCraft> findAll(Iterable<String> ids) {
		List<DesignerCraft> list=new ArrayList<DesignerCraft>();
		for(String id:ids){
			DesignerCraft dc=designerCraftRepository.findOne(id);
			System.out.println("1:"+dc.getId());
			System.out.println("2:"+dc.getAttachments());
			dc.setPicUrl(Constant.REMOTE_PATH+dc.getAttachments().iterator().next().getSaveFileName());
			list.add(dc);
		}
		System.out.println(list);
		return list;	
	}
}
