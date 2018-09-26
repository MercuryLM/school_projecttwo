package com.wjmShop.order.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import com.wjmShop.bean.Order;
import com.wjmShop.bean.OrderItem;
import com.wjmShop.bean.Product;
import com.wjmShop.bean.User;
import com.wjmShop.order.service.OrderService;

@Service("orderService")
public class OrderServiceImpl extends SqlSessionDaoSupport implements OrderService{

	// 保存订单的业务层模块
	@Override
	public void save(Order order) {
		this.getSqlSession().insert("orderMapping.orderSave", order);
		int oidMax = (int) this.getSqlSession().selectOne("orderMapping.getOidMax", order.getUid());
		if(order.getOrderItems() != null && order.getOrderItems().size() > 0){
			for(OrderItem item : order.getOrderItems()){
				item.setOid(oidMax);
				this.getSqlSession().insert("orderItemMapping.orderItemSave", item);
			}
		}
	}

	// 查询该用户的订单编号
	@Override
	public int selectOid(User existUser) {
		int oidMax = (int) this.getSqlSession().selectOne("orderMapping.getOidMax", existUser.getUid());
		return oidMax;
	}

	// 设置订单总页数
	@Override
	public int findCountByUid(Integer uid) {
		int oidMax = (int) this.getSqlSession().selectOne("orderMapping.getCountByUid", uid);
		return oidMax;
	}

	// 设置每页显示数据集合
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("uid", uid);
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<Order> list = this.getSqlSession().selectList("orderMapping.getPageByUid", paramMap);
		List<Product> listProduct = this.getSqlSession().selectList("productMapping.getProductByUid", uid);
		if(list != null && list.size() > 0){
			for(Order order : list){
				List<OrderItem> listItem = this.getSqlSession().selectList("orderItemMapping.getPageByOid", order.getOid());
				if(listItem != null && listItem.size() > 0 && listProduct != null && listProduct.size() > 0){
					for(OrderItem item : listItem){
						for(Product p : listProduct){
							if(p.getPid() == item.getPid()){
								item.setProduct(p);
								break;
							}
						}
					}
					order.setOrderItems(new HashSet(listItem));
				}
			}
			return list;
		}else{
			return null;
		}
	}

	// 根据订单id查询订单:
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Order findByOid(Integer uid) {
		List<Order> list = this.getSqlSession().selectList("orderMapping.getOrderByOid", uid);
		if(list != null && list.size() > 0){
			List<OrderItem> listItem = this.getSqlSession().selectList("orderItemMapping.getPageByOid", uid);
			if(listItem != null && listItem.size() > 0){
				for(OrderItem item : listItem){
					List<Product> listProduct = this.getSqlSession().selectList("productMapping.findByPid", item.getPid());
					if(listProduct != null && listProduct.size() > 0){
						item.setProduct(listProduct.get(0));
					}
				}
				list.get(0).setOrderItems(new HashSet(listItem));
			}
			return list.get(0);
		}else{
			return null;
		}
	}

	// 更新订单信息
	@Override
	public void updateInfo(Order currOrder) {
		this.getSqlSession().update("orderMapping.updateInfo", currOrder);
	}

	// 修改订单状态为2:已经付款:
	@Override
	public void updateState(Order currOrder) {
		this.getSqlSession().update("orderMapping.updateState", currOrder);
	}

	// 通过商品查找订单项
	@SuppressWarnings("unchecked")
	@Override
	public int selectOrderitem(Integer pid) {
		List<OrderItem> listItem = this.getSqlSession().selectList("orderItemMapping.getOrderitemByPid", pid);
		if(listItem != null && listItem.size() > 0){
			return listItem.size();
		}
		return 0;
	}

	// 设置总页数
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		List<Integer> list = this.getSqlSession().selectList("orderMapping.findCount");
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return 0;
	}

	// 每页显示的数据集合
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findByPage(int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<Order> list =  this.getSqlSession().selectList("orderMapping.findByPage", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	// 根据订单的id查询订单项:
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		List<OrderItem> listItem =  this.getSqlSession().selectList("orderItemMapping.getPageByOid", oid);
		if(listItem != null && listItem.size() > 0){
			for(OrderItem orderItem : listItem){
				List<Product> list = this.getSqlSession().selectList("productMapping.findByPid", orderItem.getPid());
				if(list != null && list.size() > 0){
					orderItem.setProduct(list.get(0));
				}
			}
			return listItem;
		}
		return null;
	}
}
