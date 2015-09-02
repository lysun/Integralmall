package com.doublev2v.integralmall.auth.menu;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.auth.permission.UrlAccessDefinition;
import com.doublev2v.integralmall.auth.permission.UrlAccessDefinitionManager;
import com.doublev2v.integralmall.auth.role.Role;
@Service
@Transactional
public class MenuService extends AbstractPagingAndSortingService<Menu, String>{
	private PatternMatcher pathMatcher = new AntPathMatcher();
	@Autowired
	private MenuRepository repository;
	@Autowired
	private UrlAccessDefinitionManager urlAccessDefinitionManager;

	public List<Menu> getTopMenus(){
		List<Menu> list=repository.findByParent(null);
		//根据角色或权限过滤
		return list.stream().filter((m)->menuFilter(m)).collect(Collectors.toList());
	}
	/**
	 * 根据UrlAccessDefinition表过滤menu，返回false表示当前用户无权限访问此menu的url
	 * @param menu
	 * @return
	 */
	public boolean menuFilter(Menu menu){
		Iterable<UrlAccessDefinition> list=urlAccessDefinitionManager.findAll();
		if(list!=null){
			for(UrlAccessDefinition u:list){
				if(pathMatcher.matches(u.getUrl(), menu.getUrl())){
					boolean role=true;
					if(StringUtils.isNotBlank(u.getRole())){
						role=SecurityUtils.getSubject().hasRole(u.getRole());
					}
					boolean perm=true;
					if(StringUtils.isNotBlank(u.getPerm())){
						
						perm=SecurityUtils.getSubject().isPermitted(u.getPerm());
					}
					if(!(role&&perm))//如果有不通过判断的循环结束
						return false;
				}
			}
		}
		return true;
	}
	/**
	 * 判断用户至少包含一个集合中的角色
	 * @param roles
	 * @return
	 */
	@Deprecated
	public boolean containAny(Collection<Role> roles){
		for(Role role:roles){
			if(SecurityUtils.getSubject().hasRole(role.getCode())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 根据任意tab找到其top菜单再根据top菜单获取其二级子菜单
	 * @param url
	 * @return
	 */
	public Iterable<Menu> getSecondMenus(String tab){
		Menu parent=null;
		List<Menu> list=repository.findByTab(tab);
		if(list.size()==1){
			if(list.get(0).getParent()!=null){
				parent=list.get(0).getParent();
			}else{
				parent=list.get(0);
			}
		}else{
			for(Menu menu:list){
				if(menu.getParent()==null){
					parent=menu;
					break;
				}
			}
		}
		return parent.getChilds().stream().filter((m)->menuFilter(m)).collect(Collectors.toList());
	}
}
