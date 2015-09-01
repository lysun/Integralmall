package com.doublev2v.integralmall.shop.branch;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
@Service
@Transactional
public class BranchShopService extends AbstractPagingAndSortingService<BranchShop,String>{
	@Autowired
	private BranchShopRepository repository;
	

}
