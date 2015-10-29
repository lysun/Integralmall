package com.doublev2v.integralmall.coupons;

import org.springframework.data.repository.CrudRepository;

import com.doublev2v.integralmall.coupons.Coupons.CouponsType;

public interface CouponsRepository extends CrudRepository<Coupons, String> {

	Coupons getByAccountAndType(String account, CouponsType type);
}
