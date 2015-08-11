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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.DtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.integral.IntegralService;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.order.dto.IntegralOrderDetail;
import com.doublev2v.integralmall.order.dto.IntegralOrderDetailAdapter;
import com.doublev2v.integralmall.order.dto.IntegralOrderDto;
import com.doublev2v.integralmall.order.dto.IntegralOrderDtoAdapter;
import com.doublev2v.integralmall.user.User;
import com.doublev2v.integralmall.user.UserService;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;
import com.doublev2v.integralmall.util.SystemErrorCodes;

@Service
@Transactional
public class IntegralOrderService extends DtoPagingService<IntegralOrder,IntegralOrderDto,String>{
	
	@Autowired
	private IntegralOrderRepository repository;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderMerchandiseRepository orderMerchandiseRepository;
	@Autowired
	private MerchandiseService merchandiseService;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private IntegralOrderDtoAdapter adapter;
	@Autowired
	private IntegralOrderDetailAdapter detailAdapter;
	/**
	 * 直接下单
	 * @param entity
	 * @return
	 */
	public void order(String merchandiseId,String userId) {
		IntegralOrder order = new IntegralOrder();
		Merchandise m=merchandiseService.getDo(merchandiseId);
		if(Constant.UNSHELVE.equals(m.getIsShelve())||m.getExpiryDate()==null?false:m.getExpiryDate().isBefore(LocalDateTime.now()))
			throw new ErrorCodeException(SystemErrorCodes.MERCHANDISE_DISABLED,"商品已过期或已下架");
		User user=userService.findOne(userId);
		order.setOrderDate(new Date());
		order.setOrderNo(UUID.randomUUID().toString());
		if(Constant.ACTUAL.equals(m.getIsActual())){
			order.setStatus(Constant.UNDELIVER);
		}else{
			order.setStatus(Constant.UNUSED);
		}
		order.setUser(user);
		OrderMerchandise om=new OrderMerchandise();
		om.setCount(1);
		if(Constant.VIRTUAL.equals(m.getIsActual())){
			om.setCouponCode(UUID.randomUUID().toString());
			om.setExpiryDate(m.getExpiryDate());
		}
		om.setIntegralCount(m.getIntegralCount());
		om.setMerchandise(m);
		om.setOrder(order);
		order.setOrderMerchandise(om);
		repository.save(order);//保存订单
		orderMerchandiseRepository.save(om);
		//减少库存
		merchandiseService.updateStock(merchandiseId, 1);
		//扣减积分
		integralService.minusIntegralCount(user,m.getIntegralCount());
	}
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(String id) {
		IntegralOrder order=repository.findOne(id);
		if(Constant.UNUSED.equals(order.getStatus())||
				Constant.UNDELIVER.equals(order.getStatus())){
			order.setStatus(Constant.ORDER_CANCEL);//取消订单
			repository.save(order);
			OrderMerchandise om=order.getOrderMerchandise();
			Merchandise merchandise=om.getMerchandise();
			merchandiseService.updateStock(merchandise.getId(), -1);//添加库存
			integralService.plusIntegralCount(order.getUser(),merchandise.getIntegralCount());//积分添加
		}else{//已使用、已发货、已取消的订单不可取消
			throw new ErrorCodeException(SystemErrorCodes.ORDER_CANNOT_CANCEL,"订单不可取消");
		}
	}	

	/**
	 * 获取列表数据
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @param orderBy
	 * @param seq
	 * @return
	 */
	public PagedList<IntegralOrderDto> getList(Integer pageNo,Integer pageSize,String userId,
			String search,String startDate,String endDate,String orderBy,Direction seq){
		PageRequest page=new PageRequest(pageNo-1, pageSize);
		if(orderBy!=null){
			page=new PageRequest(pageNo-1, pageSize,new Sort(seq, orderBy));
		}
		Page<IntegralOrder> list = repository.findAll(getQueryClause(userId,search,startDate,endDate), page);
		return new PagedList<IntegralOrderDto>(list.map(adapter));
    }
	
	public IntegralOrderDetail getIntegralOrderDetail(String id){
		return detailAdapter.convert(repository.findOne(id));
	}
	/**
	 * 获取当前用户的订单的客户端列表
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public PagedList<IntegralOrderDetail> getList(Integer pageNo,Integer pageSize,String userId){
		PageRequest page=new PageRequest(pageNo-1, pageSize);
		Page<IntegralOrder> list = repository.findAll(getQueryClause(userId,null,null,null), page);
		List<IntegralOrderDetail> listDetail=new ArrayList<IntegralOrderDetail>();
		listDetail.addAll(detailAdapter.convertSimpleList(list.getContent()));//转换dto
		Page<IntegralOrderDetail> result=new PageImpl<IntegralOrderDetail>(listDetail,page,list.getTotalElements());
		return new PagedList<IntegralOrderDetail>(result);
	}
	
	/**
	 * 返回查询条件Specification
	 * @param userId
	 * @param search
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Specification<IntegralOrder> getQueryClause(String userId,
			String search,String startDate,String endDate){
        return new Specification<IntegralOrder>() {
            @Override
            public Predicate toPredicate(Root<IntegralOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();//一个predicate为一个条件
                if(StringUtils.isNotBlank(userId)){
                	predicate.add(cb.equal(root.get("user").as(User.class), userService.findOne(userId)));
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
                    Join<IntegralOrder,User> userJoin = root.join(root.getModel().getSingularAttribute("user",User.class),JoinType.LEFT);
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
