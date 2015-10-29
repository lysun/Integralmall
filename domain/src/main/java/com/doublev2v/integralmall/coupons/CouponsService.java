package com.doublev2v.integralmall.coupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.integralmall.coupons.Coupons.CouponsType;

@Service
@Transactional
public class CouponsService {

	@Autowired
	private CouponsRepository repository;
	
	public boolean hasUsed(String account, CouponsType type) {
		Coupons coupons=repository.getByAccountAndType(account, type);
		return coupons!=null;
	}
	
	public void useCoupons(String account, CouponsType type) {
		if(!hasUsed(account, type)) {
			Coupons coupons=new Coupons();
			coupons.setAccount(account);
			coupons.setType(type);
			repository.save(coupons);
		}
	}	
}
