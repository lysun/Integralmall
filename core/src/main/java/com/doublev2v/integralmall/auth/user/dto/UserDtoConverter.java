package com.doublev2v.integralmall.auth.user.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.auth.role.Role;
import com.doublev2v.integralmall.auth.role.RoleRepository;
import com.doublev2v.integralmall.auth.user.User;

@Component
public class UserDtoConverter extends SimpleDtoConverter<User, UserDto> {
	@Autowired
	private RoleRepository roleRepository;
	public UserDto postConvert(User d,UserDto t){
		t.setUserRole(d.getRoles().iterator().next());//暂时每个用户只有一个角色
		return t;
	}
	public User postConvertD(UserDto t,User d){
		return postUpdate(t,d);
	}
	public User postUpdate(UserDto t,User d){
		Role role=roleRepository.findOne(t.getRoleId());
		Set<Role> roles=new HashSet<Role>();
		roles.add(role);
		d.setRoles(roles);
		return d;
	}
}
