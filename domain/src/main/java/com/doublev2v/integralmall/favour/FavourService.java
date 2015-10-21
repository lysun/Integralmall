package com.doublev2v.integralmall.favour;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
@Service
@Transactional
public class FavourService extends AbstractPagingAndSortingService<Favour, String>{
	@Autowired
	private FavourRepository favourRepository;
	
	public Favour findByOriginId(String originId) {
		return favourRepository.findByOriginId(originId);
	}
	public Favour createFavour(String originId){
		Favour favour=new Favour();
		favour.setOriginId(originId);
		favour.setTotalCount(0);
		return favour;
	}
	
	/**
	 * 加1
	 * @param favour
	 * @return
	 */
	public Favour plusFavour(Favour favour){
		favour.setTotalCount(favour.getTotalCount()+1);
		return favourRepository.save(favour);
	}
}
