package com.doublev2v.integralmall.auth.role.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.auth.menu.Menu;
import com.doublev2v.integralmall.auth.menu.MenuRepository;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.permission.PermissionRepository;
import com.doublev2v.integralmall.auth.role.Role;
import com.doublev2v.integralmall.auth.role.RoleType;

@Component
public class RoleDtoConverter extends SimpleDtoConverter<Role, RoleDto> {
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private MenuRepository menuRepository;
	
	
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
			d.setType(RoleType.PERM);
		}
		Set<String> menuIds=t.getMenuIds();
		if(menuIds!=null){
			Set<Menu> menus=new HashSet<Menu>();
			for(String menuId:menuIds){
				menus.add(menuRepository.findOne(menuId));
			}
			d.setMenus(menus);
			d.setType(RoleType.MENU);
		}
		return d;
	}
}
