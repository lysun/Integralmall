package com.doublev2v.integralmall.auth.menu;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuRepository extends PagingAndSortingRepository<Menu, String> {
	public List<Menu> findByParent(Menu parent);
	
	public List<Menu> findByTab(String tab);
}
