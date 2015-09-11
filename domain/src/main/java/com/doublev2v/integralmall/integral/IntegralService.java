package com.doublev2v.integralmall.integral;

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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.integral.detail.IntegralDetailService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.userinfo.UserInfoRepository;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class IntegralService extends AbstractPagingAndSortingService<Integral, String>{
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private IntegralRepository repository;
	@Autowired
	IntegralDetailService integralDetailService;
	
	public PagedList<Integral> findPage(int page, int size,String search) {
		PageRequest pageable=new PageRequest(page-1, size);
		Page<Integral> result=repository.findAll(getQueryClause(search), pageable);
		return new PagedList<Integral>(result);
	}
	
	public void validateForm(String account){
		UserInfo user=userInfoRepository.findByAccount(account);
		if(user==null){
			throw new ErrorCodeException(SystemErrorCodes.NONE_ACCOUNT);
		}
		Integral integral=repository.findByUser_account(account);
		if(integral!=null){
			throw new ErrorCodeException(SystemErrorCodes.ACCOUNT_HAS_INTEGRAL);
		}
	}
	public Integral add(Integral t){
		validateForm(t.getUser().getAccount());
		Integral integral=new Integral();
		integral.setUser(userInfoRepository.findByAccount(t.getUser().getAccount()));
		integral.setTotalcount(t.getTotalcount());
		return repository.save(integral);
	}
	
	
	@Override
	public Integral update(Integral entity) {
		Integral integral=repository.findOne(entity.getId());
		if(integral==null)return null;
		integral.setTotalcount(entity.getTotalcount());
		return repository.save(integral);
	}
	
	/**
	 * 获取用户可用积分
	 * @param user
	 * @return
	 */
	public long getIntegralCount(UserInfo user){
		Integral integral=repository.findByUser(user);
		if(integral==null){
			integral=createIntegral(user,0);
		}
		return integral.getTotalcount();
	}
	
	/**
	 * 扣减用户积分,并记录明细
	 * @param user
	 * @return
	 */
	public Integral minusIntegralCount(UserInfo user,long usedCount,String origin){
		Integral integral=repository.findByUser(user);
		if(integral==null){
			integral=createIntegral(user,0);
		}
		if(integral.getTotalcount()<usedCount)
			throw new ErrorCodeException(SystemErrorCodes.NOTENOUGH_INTEGRAL,"积分不足");
		integral.setTotalcount(integral.getTotalcount()-usedCount);
		repository.save(integral);
		//生成积分明细记录
		integralDetailService.createIntegralDetail(integral, 0-usedCount,origin);
		return integral;
	}
	
	/**
	 * 增加用户积分,并记录明细
	 * @param user
	 * @return
	 */
	public Integral plusIntegralCount(UserInfo user,long count,String origin){
		Integral integral=repository.findByUser(user);
		if(integral==null){
			integral=createIntegral(user,0);
		}
		integral.setTotalcount(integral.getTotalcount()+count);
		repository.save(integral);
		//生成积分明细记录
		integralDetailService.createIntegralDetail(integral,count,origin);
		return integral;
	}
	

	private Integral createIntegral(UserInfo user,long totalcount){
		Integral integral=new Integral();
		integral.setUser(user);
		integral.setTotalcount(totalcount);
		return repository.save(integral);
	}
	
	
	private Specification<Integral> getQueryClause(String search){
        return new Specification<Integral>() {
            @Override
            public Predicate toPredicate(Root<Integral> root, CriteriaQuery<?> query,
            		CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                if(StringUtils.isNotBlank(search)){
                	Join<Integral,UserInfo> join = root.join(root.getModel().getSingularAttribute("user",UserInfo.class),JoinType.INNER);
               	 	predicate.add(cb.like(join.get("account"),"%"+ search+"%"));
                }
               
                Predicate[] pre = new Predicate[predicate.size()];
                query.where(predicate.toArray(pre));//将where字句给query
                query.orderBy(cb.desc(root.get("createTime")));//默认按创建日期排序
                return query.getRestriction();
            }
        };
    }
	
}
