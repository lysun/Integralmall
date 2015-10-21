package com.doublev2v.integralmall.questionnaire.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.doublev2v.integralmall.questionnaire.OrderedItem;
import com.doublev2v.integralmall.questionnaire.QuestionNaireItems;

@Component
public class QuestionNaireItemsAdapter {

	public QuestionNaireItemsVo convertToVo(QuestionNaireItems i) {
		QuestionNaireItemsVo vo=new QuestionNaireItemsVo();
		vo.setAge(ctl(i.getAge()));
		vo.setColor(ctl(i.getColor()));
		vo.setOccupation(ctl(i.getOccupation()));
		vo.setPants(ctl(i.getPants()));
		vo.setPrice(ctl(i.getPrice()));
		vo.setShirt(ctl(i.getShirt()));
		vo.setSize(ctl(i.getSize()));
		vo.setSkirt(ctl(i.getSkirt()));
		vo.setStyle(ctl(i.getStyle()));
		return vo;
	}
	
	public QuestionNaireItems convertToDo(QuestionNaireItemsVo vo) {
		QuestionNaireItems items=new QuestionNaireItems();
		items.setAge(ltc(vo.getAge()));
		items.setColor(ltc(vo.getColor()));
		items.setOccupation(ltc(vo.getOccupation()));
		items.setPants(ltc(vo.getPants()));
		items.setShirt(ltc(vo.getShirt()));
		items.setSize(ltc(vo.getSize()));
		items.setSkirt(ltc(vo.getSkirt()));
		items.setStyle(ltc(vo.getStyle()));
		items.setPrice(ltc(vo.getPrice()));
		return items;
	}
	
	private List<String> ctl(Set<OrderedItem> items) {
		if(items==null) return null;
		List<String> list=new ArrayList<>();
		for (OrderedItem item : items) {
			list.add(item.getValue());
		}
		return list;
	}
	
	private Set<OrderedItem> ltc(List<String> list) {
		if(list==null) return null;
		Set<OrderedItem> items=new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			OrderedItem item=new OrderedItem();
			item.setOrdernum(i);
			item.setValue(list.get(i));
			items.add(item);
		}
		return items;
	}
}
