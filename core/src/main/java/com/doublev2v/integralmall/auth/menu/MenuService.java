package com.doublev2v.integralmall.auth.menu;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.auth.role.Role;
@Service
@Transactional
public class MenuService extends AbstractPagingAndSortingService<Menu, String>{

	@Autowired
	private MenuRepository repository;
	
	public List<Menu> getTopMenus(){
		List<Menu> list=repository.findByParent(null);
		//根据权限过滤
		return list.stream().filter((m)->containAny(m.getRoles())).collect(Collectors.toList());
	}
	/**
	 * 判断用户至少包含一个集合中的角色
	 * @param roles
	 * @return
	 */
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
		return parent.getChilds();
	}
}
