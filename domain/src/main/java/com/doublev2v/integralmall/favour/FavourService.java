package com.doublev2v.integralmall.favour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class FavourService extends AbstractPagingAndSortingService<Favour, String>{
	@Autowired
	private FavourRepository favourRepository;
	
	public Favour clickFavour(UserInfo user,String originId) {
		if(user==null)throw new IllegalArgumentException("获取不到用户");
		//判断用户有没有对该商品点过赞
		if(favourRepository.findOne(getQueryClause(user,originId))!=null)
			throw new ErrorCodeException(SystemErrorCodes.USER_CLICK_FAVOUR);
		//判断用户一共点赞次数是否超过5次
		List<Favour> list=favourRepository.findAll(getQueryClause(user,null));
		if(list.size()>=5)
			throw new ErrorCodeException(SystemErrorCodes.USER_FAVOUR_FIVE);
		Favour favour=favourRepository.findByOriginId(originId);
		if(favour==null){
			favour=new Favour();
			favour.setOriginId(originId);
			favour.setTotalCount(1);
			Set<UserInfo> users=new HashSet<UserInfo>();
			users.add(user);
			favour.setUsers(users);
		}else{
			Set<UserInfo> users=favour.getUsers();
			users.add(user);
			favour.setTotalCount(favour.getTotalCount()+1);
		}
		return favourRepository.save(favour);	
	}
	/**
	 * 取消点赞
	 * @param user
	 * @param originId
	 */
	public void cancelFavour(UserInfo user,String originId){
		if(user==null)throw new IllegalArgumentException("获取不到用户");
		if(favourRepository.findOne(getQueryClause(user,originId))!=null){
			Favour favour=favourRepository.findByOriginId(originId);
			Set<UserInfo> users=favour.getUsers().stream().filter((f)->!f.getId().equals(user.getId())).collect(Collectors.toSet());
			favour.setUsers(users);
			favour.setTotalCount(favour.getTotalCount()-1);
			favourRepository.save(favour);
		}	
	}
	/**
	 * 获取用户点赞的商品数
	 * @param user
	 * @return
	 */
	public int getUserFavourCount(UserInfo user){
		if(user==null)throw new IllegalArgumentException("获取不到用户");
		return favourRepository.findAll(getQueryClause(user,null)).size();
	}
	/**
	 * 获取用户对某个商品是否点赞
	 * @param user
	 * @param originId
	 * @return
	 */
	public int getUserFavourCount(UserInfo user,String originId){
		if(user==null)throw new IllegalArgumentException("获取不到用户");
		return favourRepository.findAll(getQueryClause(user,originId)).size();
	}
	private Specification<Favour> getQueryClause(UserInfo user,String originId){
        return new Specification<Favour>() {
            @Override
            public Predicate toPredicate(Root<Favour> root, CriteriaQuery<?> query,
            		CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                if(user!=null)
                	predicate.add(cb.isMember(user, root.get("users")));
                if(StringUtils.isNotBlank(originId))
                	predicate.add(cb.equal(root.get("originId").as(String.class), originId));
                Predicate[] pre = new Predicate[predicate.size()];
                query.where(predicate.toArray(pre));//将where字句给query
                return query.getRestriction();
            }
        };
    }
}
