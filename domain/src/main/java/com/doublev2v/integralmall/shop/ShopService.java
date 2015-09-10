package com.doublev2v.integralmall.shop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractLogicDeleteService;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.integralmall.shop.branch.BranchShopService;
@Service
@Transactional
public class ShopService extends AbstractLogicDeleteService<Shop,String>{
	@Autowired
	private ShopRepository repository;
	@Autowired
	private BranchShopService branchShopService;
	
	public void delete(Shop t) {
		t.setDeleted(true);
		if(t.getBranchShops()!=null&&t.getBranchShops().size()>0){//删除所有分店
			branchShopService.delete(t.getBranchShops());
		}
		getRepository().save(t);
	}
	/**
	 * 根据不同的条件查询商户信息
	 * @param page
	 * @param num
	 * @param classify
	 * @param tag
	 * @return
	 */
	public Page<Shop> findPage(Pageable page,String num,CategoryItem tag){
		return repository.findAll(getQueryClause(num,tag), page);
	}
	/**
	 * 返回查询条件Specification
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Specification<Shop> getQueryClause(String num,CategoryItem tag){
        return new Specification<Shop>() {
            @Override
            public Predicate toPredicate(Root<Shop> root, CriteriaQuery<?> query,
            		CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                predicate.add(cb.isFalse(root.get("deleted")));
                if(StringUtils.isNotBlank(num)){
                	predicate.add(cb.equal(root.get("num"), num));
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
