package com.wjmShop.user.action;
import java.util.List;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.wjmShop.bean.Category;
import com.wjmShop.bean.Product;
import com.wjmShop.category.service.CategoryService;
import com.wjmShop.product.service.ProductService;
import com.wjmShop.user.service.UserService;
import com.wjmShop.utils.BaseAction;

public class IndexAction extends BaseAction {

	private static final long serialVersionUID = 4067622141332715241L;

	// 注入UserService
	@Resource
	private UserService userService;
	
	// 注入一级分类的Service:
	@Resource
	private CategoryService categoryService;
	
	// 注入商品的Service
	@Resource
	private ProductService productService;
		
	public String excute () {
		// 查询所有一级分类集合
		List<Category> cList = categoryService.findAll();
		// 将一级分类存入到Session的范围:
		session.put("cList", cList);
		// 查询热门商品:
		List<Product> hList = productService.findHot();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("hList", hList);
		// 查询最新商品:
		List<Product> nList = productService.findNew();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("nList", nList);
		
		return SUCCESS;
	}

}
