package com.doublev2v.integralmall.auth.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.doublev2v.integralmall.auth.user.UserService;
 
/**
 * SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；
 * 也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作  
 * @author Administrator
 *
 */
public class UserRealm extends AuthorizingRealm {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
     * 获取身份验证信息
     */
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)  
            throws AuthenticationException {
    	if (authcToken == null) {  
            throw new AuthorizationException("AuthenticationToken argument cannot be null.");  
        }
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
    } 
    /**
     * 根据用户身份获取授权信息
     */
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
        // 根据用户配置用户与权限  
        if (principals == null) {  
            throw new AuthorizationException("PrincipalCollection argument cannot be null.");  
        }
        String username = (String) getAvailablePrincipal(principals);  
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        // 增加角色  
        info.addRoles(userService.loadRoles(username));
        // 增加权限 
        info.addStringPermissions(userService.loadPermissions(username));
        return info;  
    }  
  
     
}  