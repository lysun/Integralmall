package com.doublev2v.integralmall.auth.user.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.auth.role.Role;
import com.doublev2v.integralmall.auth.role.RoleRepository;
import com.doublev2v.integralmall.auth.role.dto.RoleDto;
import com.doublev2v.integralmall.auth.role.dto.RoleDtoConverter;
import com.doublev2v.integralmall.auth.user.User;

@Component
public class UserDtoConverter extends SimpleDtoConverter<User, UserDto> {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleDtoConverter roleDtoConverter;
	public UserDto postConvert(User d,UserDto t){
		Set<Role> roles=d.getRoles();
		if(roles!=null){
			Set<RoleDto> roleDtos=new HashSet<RoleDto>(roleDtoConverter.convertTs(roles));
			t.setRoleDtos(roleDtos);
		}
		return t;
	}
	public User postConvertD(UserDto t,User d){
		return postUpdate(t,d);
	}
	public User postUpdate(UserDto t,User d){
		if(t.getRoleIds()!=null){
			Set<Role> roles=new HashSet<Role>();
			for(String roleId:t.getRoleIds()){
				roles.add(roleRepository.findOne(roleId));
			}
			d.setRoles(roles);
		}
		return d;
	}
}
