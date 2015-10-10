package com.doublev2v.integralmall.auth.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.role.Role;
import com.doublev2v.integralmall.util.SystemErrorCodes;

@Service
@Transactional
public class UserService extends AbstractPagingAndSortingService<User, String>{

	@Autowired
	public UserRepository userRepository;

	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public List<String> loadRoles(String username){
		List<String> roles = new ArrayList<String>();
		User user=findByUsername(username);
		if (user.getRoles() != null) {
        	for(Role r:user.getRoles()){
        		roles.add(r.getCode());
        	}
        }else
        	throw new AuthorizationException("没有角色");
		return roles;
	}
	public List<String> loadPermissions(String username){
		List<String> permissions=new ArrayList<String>();
        User user = findByUsername(username);
        if (user.getRoles() != null) {
        	for(Role r:user.getRoles()){
        		if(r.getPerms()!=null){
        			for(Permission p:r.getPerms()){
            			permissions.add(p.getCode());
            		}
        		}
        		
        	}
        }else
        	throw new AuthorizationException("没有权限");
        return permissions;
	}
	
	public void changePassword(String username,String password){
		User user = findByUsername(username);
		if(user==null){
			throw new ErrorCodeException(SystemErrorCodes.NOUSER);
		}
		user.setPassword(password);
		userRepository.save(user);
	}
	
}
