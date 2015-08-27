package com.doublev2v.integralmall.order;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.integral.IntegralService;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.coupon.Coupon;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
import com.doublev2v.integralmall.order.om.OrderMerchandiseRepository;
import com.doublev2v.integralmall.shop.ShopService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.userinfo.UserInfoService;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;
import com.doublev2v.integralmall.util.SystemErrorCodes;

@Service
@Transactional
public class IntegralOrderService extends AbstractPagingAndSortingService<IntegralOrder,String>{
	
	@Autowired
	private IntegralOrderRepository repository;
	@Autowired
	private UserInfoService userService;
	@Autowired
	private OrderMerchandiseRepository orderMerchandiseRepository;
	@Autowired
	private MerchandiseService merchandiseService;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private ShopService shopService;

	/**
	 * 下单,兑换商品
	 * @param entity
	 * @return
	 */
	public void order(UserInfo user,String merchandiseId,String addressId) {
		if(StringUtils.isBlank(merchandiseId)||merchandiseService.findOne(merchandiseId)==null)
			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"传入商品参数不正确");
		Merchandise m=merchandiseService.findOne(merchandiseId);
		if(Constant.UNSHELVE.equals(m.getIsShelve()))
			throw new ErrorCodeException(SystemErrorCodes.MERCHANDISE_UNSHELVE,"商品已下架");
		//减少库存
		merchandiseService.updateStock(merchandiseId, 1);
		//扣减积分
		integralService.minusIntegralCount(user,m.getIntegralCount(),Constant.CONVERT_MERCHANDISE);
		IntegralOrder order = new IntegralOrder();
		OrderMerchandise om=new OrderMerchandise();
		switch(m.getIsActual()){
			case Constant.VIRTUAL:
				Coupon c=(Coupon)m;
				if(c.getExpiryDate()==null?false:c.getExpiryDate().isBefore(LocalDateTime.now()))
					throw new ErrorCodeException(SystemErrorCodes.MERCHANDISE_EXPIRE,"商品已过期");
				order.setStatus(Constant.UNUSED);
				om.setCouponCode(UUID.randomUUID().toString());
				om.setExpiryDate(c.getExpiryDate());
				break;
			case Constant.ACTUAL:
				if(StringUtils.isBlank(addressId))//实物必须有收货地址
					throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT,"传入地址参数不正确");
				order.setAddressId(addressId);
				order.setStatus(Constant.UNDELIVER);
				break;
		}
		order.setShop(m.getShop());
		order.setUser(user);
		order.setOrderDate(new Date());
		order.setOrderNo(UUID.randomUUID().toString());
		om.setCount(1);
		om.setIntegralCount(m.getIntegralCount());
		om.setMerchandise(m);
		om.setOrder(order);
		order.setOrderMerchandise(om);
		repository.save(order);//保存订单
		orderMerchandiseRepository.save(om);
		
	}
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(String id) {
		if(StringUtils.isBlank(id)||repository.findOne(id)==null)
			throw new ErrorCodeException(SystemErrorCodes.IIIEGAL_ARGUMENT);
		IntegralOrder order=repository.findOne(id);
		if(Constant.UNUSED.equals(order.getStatus())||
				Constant.UNDELIVER.equals(order.getStatus())){
			order.setStatus(Constant.ORDER_CANCEL);//取消订单
			repository.save(order);
			OrderMerchandise om=order.getOrderMerchandise();
			Merchandise merchandise=om.getMerchandise();
			merchandiseService.updateStock(merchandise.getId(), -1);//添加库存
			integralService.plusIntegralCount(order.getUser(),merchandise.getIntegralCount(),
					Constant.CONVERT_MERCHANDISE_CANCEL);//积分添加
		}else{//已使用、已发货、已取消的订单不可取消
			throw new ErrorCodeException(SystemErrorCodes.ORDER_CANNOT_CANCEL,"订单已取消或已生效，不可取消");
		}
	}	

	/**
	 *  获取列表数据
	 * @param page
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @param orderBy
	 * @param seq
	 * @return
	 */
	public Page<IntegralOrder> findPage(Pageable page,UserInfo user,String search,
			String startDate,String endDate,String orderBy,Direction seq){
		if(orderBy!=null){
			page=new PageRequest(page.getPageNumber(), page.getPageSize(),new Sort(seq, orderBy));
		}
		return repository.findAll(getQueryClause(user,search,startDate,endDate), page);
    }
	
	/**
	 * 根据兑换码使用商品
	 * @param couponCode
	 */
	public void useCashCoupon(String couponCode){
		if(StringUtils.isBlank(couponCode)||orderMerchandiseRepository.findByCouponCode(couponCode)==null)
			throw new ErrorCodeException(SystemErrorCodes.COUPONCODE_CANNOT_USE,"兑换码不可用");
		OrderMerchandise orderMerchandise=orderMerchandiseRepository.findByCouponCode(couponCode);
		IntegralOrder integralOrder=orderMerchandise.getOrder();
		if(Constant.UNUSED.equals(integralOrder.getStatus())){
			integralOrder.setStatus(Constant.USED);
			orderMerchandise.setUsageDate(new Date());
			orderMerchandiseRepository.save(orderMerchandise);
			repository.save(integralOrder);
		}else{
			throw new ErrorCodeException(SystemErrorCodes.COUPONCODE_CANNOT_USE,"兑换码不可用");
		}
	}
	/**
	 * 返回查询条件Specification
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Specification<IntegralOrder> getQueryClause(UserInfo user,String search,
			String startDate,String endDate){
        return new Specification<IntegralOrder>() {
            @Override
            public Predicate toPredicate(Root<IntegralOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                //前端UserInfo用户过滤
                if(user!=null){
                	predicate.add(cb.equal(root.get("user").as(UserInfo.class), user));
                }
                try {
	                if(StringUtils.isNotBlank(startDate)){
	                    predicate.add(cb.greaterThanOrEqualTo(root.get("orderDate").as(Date.class),DateUtil.parse(startDate)));
	                }
	                if(StringUtils.isNotBlank(endDate)){
	                    predicate.add(cb.lessThanOrEqualTo(root.get("orderDate").as(Date.class), DateUtil.parse(endDate)));
	                }
                } catch (ParseException e) {
					e.printStackTrace();
				}
                if (StringUtils.isNotBlank(search)){
                    //两张表关联查询
                    Join<IntegralOrder,UserInfo> userJoin = root.join(root.getModel().getSingularAttribute("user",UserInfo.class),JoinType.LEFT);
                    predicate.add(cb.or(cb.like(userJoin.get("username").as(String.class), "%" + search + "%"),
                    		cb.like(root.get("orderNo").as(String.class), "%" + search + "%")));
                }
                Predicate[] pre = new Predicate[predicate.size()];
                query.where(predicate.toArray(pre));//将where字句给query
                query.orderBy(cb.desc(root.get("createTime")));//默认按创建日期排序
                return query.getRestriction();
            }
        };
    }
}
