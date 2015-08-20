package com.doublev2v.integralmall.auth;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.auth.authority.Authority;
import com.doublev2v.integralmall.auth.role.Role;
import com.doublev2v.integralmall.auth.token.UserToken;
import com.doublev2v.integralmall.auth.token.UserTokenRepository;
import com.doublev2v.integralmall.auth.user.User;
import com.doublev2v.integralmall.auth.user.UserRepository;
import com.doublev2v.integralmall.util.SystemErrorCodes;


@Service
@Transactional
public class UserAuthService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserTokenRepository userTokenRepository;
	
	@Override
	public User loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("username is not found");
		}
		return loadAuths(user);
	}

	/**
	 * 验证token对应的用户，并返回user
	 * @param token
	 * @return
	 */
	public User authenticate(String token){
		UserToken userToken=userTokenRepository.findByToken(token);
		User user=userToken.getUser();
		if(user.isEnabled()){
			return loadAuths(user);
		}
		return null;
	}
	/**
	 * 注册
	 * @param username
	 * @param password
	 * @return
	 */
	public User regist(String username,String password){
		User user=userRepository.findByUsername(username);
		if(user==null){
			user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setVerified(true);
			userRepository.save(user);
		}else
			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"此用户已经注册");
		UserToken token=userTokenRepository.findByUser(user);
		if(token==null){
			token=new UserToken();
			token.setUser(user);
		}
		token.setToken(UUID.randomUUID().toString());
		userTokenRepository.save(token);
		return user;
	}
	/**
	 * 登陆并返回token
	 * @param username
	 * @param password
	 * @return
	 */
	public UserToken login(String username,String password){
		//登陆的时候清除之前登录用户的session
		SecurityContextHolder.clearContext();
		User user=userRepository.findByUsername(username);
		if(user!=null&&user.getPassword().equals(password)&&user.isEnabled()){
			UserToken token=userTokenRepository.findByUser(user);
			token.setToken(UUID.randomUUID().toString());//登陆一次换一次token
			userTokenRepository.save(token);
			SecurityContext context=SecurityContextHolder.getContext();
			//自定义登陆认证，将权限及用户信息存入SecurityContext
			UsernamePasswordAuthenticationToken auth=
					new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
			auth.setDetails(user);
			context.setAuthentication(auth);
			SecurityContextHolder.setContext(context);
			return token;
		}else
			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"用户名或密码不正确");
	}
	
	
	public User loadAuths(User user){
		Set<Role> roles=user.getRoles();
		Set<Authority> auths=new HashSet<Authority>();
		for(Role role:roles){//将权限赋给user
			auths.addAll(role.getAuthorities());
		}
		user.setAuthorities(auths);
		return user;
	}
}
