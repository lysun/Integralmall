package com.doublev2v.integralmall.shop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.integralmall.tag.Tag;
@Service
@Transactional
public class ShopService extends AbstractPagingAndSortingService<Shop,String>{
	@Autowired
	private ShopRepository repository;
	
	public Page<Shop> findPage(Pageable page,CategoryItem classify,Tag tag){
		return repository.findAll(getQueryClause(classify,tag), page);
	}
	/**
	 * 返回查询条件Specification
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Specification<Shop> getQueryClause(CategoryItem classify,Tag tag){
        return new Specification<Shop>() {
            @Override
            public Predicate toPredicate(Root<Shop> root, CriteriaQuery<?> query,
            		CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                if (classify!=null){
                	predicate.add(cb.equal(root.get("classify"), classify));
                }
                if (tag!=null){
                    predicate.add(cb.isMember(tag, root.get("tags")));
                }
                Predicate[] pre = new Predicate[predicate.size()];
                query.where(predicate.toArray(pre));//将where字句给query
                query.orderBy(cb.desc(root.get("createTime")));//默认按创建日期排序
                return query.getRestriction();
            }
        };
    }

}
