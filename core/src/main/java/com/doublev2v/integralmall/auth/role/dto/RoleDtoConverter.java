package com.doublev2v.integralmall.auth.role.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.permission.PermissionRepository;
import com.doublev2v.integralmall.auth.role.Role;

@Component
public class RoleDtoConverter extends SimpleDtoConverter<Role, RoleDto> {
	@Autowired
	private PermissionRepository permissionRepository;
	public RoleDto postConvert(Role d,RoleDto t){
		Set<Permission> perms=d.getPerms();
		if(perms!=null){
			Set<Permission> permDtos=new HashSet<Permission>();
			for(Permission perm:perms){
				Permission permDto=new Permission();
				permDto.setId(perm.getId());
				permDto.setName(perm.getName());
				permDto.setCode(perm.getCode());
				permDtos.add(permDto);
			}
			t.setPermDtos(permDtos);
		}
		
		return t;
	}
	public Role postConvertD(RoleDto t,Role d){
		return postUpdate(t,d);
	}
	public Role postUpdate(RoleDto t,Role d){
		Set<String> permIds=t.getPermIds();
		if(permIds!=null){
			Set<Permission> perms=new HashSet<Permission>();
			for(String permId:permIds){
				perms.add(permissionRepository.findOne(permId));
			}
			d.setPerms(perms);
		}
		return d;
	}
}
