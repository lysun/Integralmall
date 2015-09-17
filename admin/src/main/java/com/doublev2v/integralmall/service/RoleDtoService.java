package com.doublev2v.integralmall.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.AbstractPagingDtoService;
import com.doublev2v.integralmall.auth.role.Role;
import com.doublev2v.integralmall.entity.RoleDto;

@Service
@Transactional
public class RoleDtoService extends AbstractPagingDtoService<Role,RoleDto, String>{

	
}
