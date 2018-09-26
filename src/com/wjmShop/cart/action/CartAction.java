package com.wjmShop.cart.action;

import javax.annotation.Resource;
import com.wjmShop.bean.Product;
import com.wjmShop.cart.bean.Cart;
import com.wjmShop.cart.bean.CartItem;
import com.wjmShop.product.service.ProductService;
import com.wjmShop.utils.BaseAction;

/**
 * 购物车Action
 * 
 * @author
 * 
 */
public class CartAction extends BaseAction {

	private static final long serialVersionUID = -1501250023683437113L;
	// 接收pid
	private Integer pid;
	// 接收数量count
	private Integer count;
	// 注入商品的Service
	@Resource
	private ProductService productService;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// 将购物项添加到购物车:执行的方法
	public String addCart() {
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		// 设置数量:
		cartItem.setCount(count);
		// 根据pid进行查询商品:
		Product product = productService.findByPid(pid);
		// 设置商品:
		cartItem.setProduct(product);
		// 将购物项添加到购物车.
		// 购物车应该存在session中.
		Cart cart = getCart();
		cart.addCart(cartItem);

		return "addCart";
	}

	// 清空购物车的执行的方法:
	public String clearCart(){
		// 获得购物车对象.
		Cart cart = getCart();
		// 调用购物车中清空方法.
		cart.clearCart();
		return "clearCart";
	}
	
	// 从购物车中移除购物项的方法:
	public String removeCart(){
		// 获得购物车对象
		Cart cart = getCart();
		// 调用购物车中移除的方法:
		cart.removeCart(pid);
		// 返回页面:
		return "removeCart";
	}
	
	// 我的购物车:执行的方法
	public String myCart(){
		return "myCart";
	}
	
	/**
	 * 获得购物车的方法:从session中获得购物车.
	 * @return
	 */
	private Cart getCart() {
		Cart cart = (Cart) session.get("cart");
		if (cart == null) {
			cart = new Cart();
			session.put("cart", cart);
		}
		return cart;
	}
}
