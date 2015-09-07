package com.doublev2v.integralmall.auth.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;

@Service
@Transactional
public class UrlAccessDefinitionManager extends AbstractPagingAndSortingService<UrlAccessDefinition, String>{

	@Autowired
	public UrlAccessDefinitionRepository repository;

	
	
	
}
