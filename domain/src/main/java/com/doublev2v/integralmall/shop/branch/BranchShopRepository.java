package com.doublev2v.integralmall.shop.branch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.foundation.core.repository.LogicDeleteRepository;

public interface BranchShopRepository extends PagingAndSortingRepository<BranchShop, String>,
	LogicDeleteRepository<BranchShop, String>,
	JpaSpecificationExecutor<BranchShop>{
	
	public List<BranchShop> findByDeletedAndShop_id(boolean deleted,String shopId);
	
	
}
