package com.doublev2v.integralmall.auth.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;

@Service
@Transactional
public class PermissionService extends AbstractPagingAndSortingService<Permission, String>{
	@Autowired
	private PermissionRepository repository;
	@Override
	public Permission update(Permission t) {
		if(t==null)return null;
		Permission perm=repository.findOne(t.getId());
		System.out.println(perm.getUpdateTime());
		perm.setCode(t.getCode());
		perm.setDescription(t.getDescription());
		perm.setName(t.getName());
		perm.setType(t.getType());
		return getRepository().save(perm);
	}
	
}
