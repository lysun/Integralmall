package com.doublev2v.integralmall.auth.role.dto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.AbstractPagingDtoService;
import com.doublev2v.integralmall.auth.role.Role;

@Service
@Transactional
public class RoleDtoService extends AbstractPagingDtoService<Role,RoleDto, String>{

	
}
