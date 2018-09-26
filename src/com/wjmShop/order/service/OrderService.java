package com.wjmShop.order.service;

import java.util.List;

import com.wjmShop.bean.Order;
import com.wjmShop.bean.OrderItem;
import com.wjmShop.bean.Product;
import com.wjmShop.bean.User;

public interface OrderService {
	// 保存订单的业务层模块
	public void save(Order order);
	// 查询该用户的订单编号
	public int selectOid(User existUser);
	// 设置总记录数
	public int findCountByUid(Integer uid);
	// 设置每页显示数据集合
	public List<Order> findPageByUid(Integer uid, int begin, int limit);
	// 根据订单id查询订单:
	public Order findByOid(Integer uid);
	// 更新订单信息
	public void updateInfo(Order currOrder);
	// 修改订单状态为2:已经付款:
	public void updateState(Order currOrder);
	// 通过商品查找商品的订单项
	public int selectOrderitem(Integer pid);
	// 设置总页数
	public int findCount();
	// 每页显示的数据集合
	public List<Order> findByPage(int begin, int limit);
	// 根据订单的id查询订单项:
	public List<OrderItem> findOrderItem(Integer oid);
}
