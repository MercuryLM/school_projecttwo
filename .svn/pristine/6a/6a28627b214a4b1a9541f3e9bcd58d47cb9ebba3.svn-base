package com.wjmShop.order.adminAction;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.Order;
import com.wjmShop.bean.OrderItem;
import com.wjmShop.order.service.OrderService;
import com.wjmShop.utils.BaseAction;
import com.wjmShop.utils.PageBean;

/**
 * 后台订单管理的Action
 * @author
 *
 */
public class AdminOrderAction extends BaseAction implements ModelDriven<Order>{

	private static final long serialVersionUID = 5588494293533266136L;
	// 模型驱动使用的类
	private Order order = new Order();

	public Order getModel() {
		return order;
	}
	// 接收page参数
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	// 注入OrderService
	@Resource
	private OrderService orderService;

	// 提供后台查询所有订单的方法:
	public String findAll(){
		// 订单的分页查询
		PageBean<Order> pageBean = this.findAll(page);
		// 将数据存入到值栈中保存到页面
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转:
		return "findAll";
	}

	// 业务层查询所有订单方法
	public PageBean<Order> findAll(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置参数
		pageBean.setPage(page);
		// 设置每页显示的记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = orderService.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合
		int begin = (page - 1) * limit;
		List<Order> list = orderService.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	// 修改订单状态
	public String updateState(){
		// 根据id查询订单
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.updateState(currOrder);
		// 页面跳转
		return "updateStateSuccess";
	}
	
	// 根据订单的id查询订单项:
	public String findOrderItem(){
		// 根据订单id查询订单项:
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// 显示到页面:
		ActionContext.getContext().getValueStack().set("list", list);
		// 页面跳转
		return "findOrderItem";
	}
}
