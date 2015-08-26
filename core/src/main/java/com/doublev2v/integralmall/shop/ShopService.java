package com.doublev2v.integralmall.shop;

import javax.transaction.Transactional;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.auth.realm.ShiroContext;
import com.doublev2v.integralmall.auth.user.User;
import com.doublev2v.integralmall.util.Constant;
@Service
@Transactional
public class ShopService extends AbstractPagingAndSortingService<Shop,String>{
	@Autowired
	private ShopRepository repository;
	@Override
	public Shop add(Shop entity) {
		if(entity==null)return null;
		User user=ShiroContext.getCurrentUser();
		if(user==null)
			throw new AuthorizationException("请先登录");
		entity.setUser(user);
		return getRepository().save(entity);
	}
	@Override
	public PagedList<Shop> findPage(int page, int size) {
		PageRequest pageable=new PageRequest(page-1, size);
		Page<Shop> result=null;
		User user=ShiroContext.getCurrentUser();
		if(user!=null){
			if(SecurityUtils.getSubject().hasRole(Constant.ROLE_SHOP_USER)){
				result=repository.findByUser(user,pageable);
			}
		}
		result=repository.findAll(pageable);
		return new PagedList<>(result);
	}
	
	public Shop getShopByUser(User user){
		return repository.findByUser(user);
	}
}
