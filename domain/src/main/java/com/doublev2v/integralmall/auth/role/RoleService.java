package com.doublev2v.integralmall.auth.role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;

@Service
@Transactional
public class RoleService extends AbstractPagingAndSortingService<Role, String>{
	
}
