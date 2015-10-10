package com.doublev2v.integralmall.shop.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractLogicDeleteService;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class BranchShopService extends AbstractLogicDeleteService<BranchShop,String>{
	@Autowired
	private BranchShopRepository repository;
	
	public void logicDelete(BranchShop t) {
		if(t.getMerchs()!=null&&t.getMerchs().size()>0){//遍历商品看是否有上架的
			for(Merchandise m:t.getMerchs()){
				if(Constant.SHELVE.equals(m.getIsShelve())){
					throw new ErrorCodeException(SystemErrorCodes.BRANCHSHOP_HAS_MERCHS);
				}
				
			}
		}
		repository.logicDelete(t);
	}
	public List<BranchShop> findByShopId(String shopId){
		return repository.findByDeletedAndShop_id(false,shopId);
	}

	public Page<BranchShop> findPage(Pageable page,String num,CategoryItem tag){
		return repository.findAll(getQueryClause(num,tag), page);
	}
	
	private Specification<BranchShop> getQueryClause(String num,CategoryItem tag){
        return new Specification<BranchShop>() {
            @Override
            public Predicate toPredicate(Root<BranchShop> root, CriteriaQuery<?> query,
            		CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                predicate.add(cb.isFalse(root.get("deleted")));//过滤删除了的
                if(StringUtils.isNotBlank(num)){
                	predicate.add(cb.like(root.get("num"), "%"+num+"%"));
                }
                if (tag!=null){
                	 Join<BranchShop,Shop> join = root.join(root.getModel().getSingularAttribute("shop",Shop.class),JoinType.INNER);
                	 predicate.add(cb.isMember(tag, join.get("tags")));
                }
                Predicate[] pre = new Predicate[predicate.size()];
                query.where(predicate.toArray(pre));//将where字句给query
                query.orderBy(cb.desc(root.get("createTime")));//默认按创建日期排序
                return query.getRestriction();
            }
        };
    }
}
