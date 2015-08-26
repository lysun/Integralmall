package com.doublev2v.integralmall.tag;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
@Service
@Transactional
public class TagService extends AbstractPagingAndSortingService<Tag,String>{

	@Autowired
	private TagRepository repository;
	@Override
	public Tag update(Tag t) {
		if(t==null)return null;
		Tag d=repository.findOne(t.getId());
		d.setName(t.getName());
		return getRepository().save(d);
	}
}
