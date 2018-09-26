package com.wjmShop.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import com.wjmShop.bean.Product;
import com.wjmShop.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends SqlSessionDaoSupport implements ProductService{

	// 查询热门商品
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findHot() {
		// 查询热门商品
		List<Product> list = this.getSqlSession().selectList("productMapping.findHot", 1);
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}

	// 查询最新商品
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findNew() {
		// 查询最新商品
		List<Product> list = this.getSqlSession().selectList("productMapping.findNew", 1);
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}

	/// 根据商品ID查询商品
	@SuppressWarnings("unchecked")
	@Override
	public Product findByPid(Integer pid) {
		// 根据商品ID查询商品
		List<Product> list = this.getSqlSession().selectList("productMapping.findByPid", pid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	// 设置一级分类查询商品总记录数
	@SuppressWarnings("unchecked")
	@Override
	public int findCountCid(Integer cid) {
		List<Integer> list = this.getSqlSession().selectList("productMapping.findCountCid",cid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return 0;
		}
	}

	// 根据一级分类ID查找商品集合
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("cid", cid);
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<Product> list = this.getSqlSession().selectList("productMapping.findByPageCid", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}

	// 设置二级分类查询商品总记录数
	@SuppressWarnings("unchecked")
	@Override
	public int findCountCsid(Integer csid) {
		List<Integer> list = this.getSqlSession().selectList("productMapping.findCountCsid",csid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return 0;
		}
	}

	// 根据二级分类ID查找商品集合
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("csid", csid);
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<Product> list = this.getSqlSession().selectList("productMapping.findByPageCsid", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}

	// 设置总页数
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		List<Integer> list = this.getSqlSession().selectList("productMapping.findCount");
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return 0;
	}

	// 每页显示的数据集合
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByPage(int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<Product> list =  this.getSqlSession().selectList("productMapping.findByPage", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	// 保存商品
	@Override
	public void save(Product product) {
		this.getSqlSession().insert("productMapping.save", product);
	}

	// 删除商品
	@Override
	public void delete(Product product) {
		this.getSqlSession().delete("productMapping.delete", product);	
	}
}
