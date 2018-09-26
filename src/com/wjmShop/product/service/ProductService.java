package com.wjmShop.product.service;

import java.util.List;

import com.wjmShop.bean.CategorySecond;
import com.wjmShop.bean.Product;

public interface ProductService {
	// 查询热门商品
	public List<Product> findHot();
	// 查询最新商品
	public List<Product> findNew();
	// 根据商品ID查询商品
	public Product findByPid(Integer pid);
	// 设置一级分类查询商品总记录数
	public int findCountCid(Integer cid);
	// 根据一级分类ID查找商品集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit);
	// 设置二级分类查询商品总记录数
	public int findCountCsid(Integer csid);
	// 根据二级分类ID查找商品集合
	public List<Product> findByPageCsid(Integer csid, int begin, int limit);
	// 设置总页数
	public int findCount();
	// 每页显示的数据集合
	public List<Product> findByPage(int begin, int limit);
	// 保存商品
	public void save(Product product);
	// 删除商品
	public void delete(Product product);

}
