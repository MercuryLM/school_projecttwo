package com.wjmShop.category.service.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.wjmShop.bean.Category;
import com.wjmShop.category.service.CategoryService;

/**
 * 一级分类的持久层对象
 * @author
 *
 */
@Service("categoryService")
public class CategoryServiceImpl extends SqlSessionDaoSupport implements CategoryService{

	// 查询所有一级分类
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		List<Category> list = this.getSqlSession().selectList("categoryMapping.findAll");
		if(list != null && list.size() > 0)
		{
			return list;
		}else{
			return null;
		}
	}

	// 添加一级分类
	@Override
	public void save(Category category) {
		this.getSqlSession().insert("categoryMapping.save", category);
	}

	// 用过Cid查找一级分类
	@SuppressWarnings("unchecked")
	@Override
	public Category findByCid(Integer cid) {
		List<Category> list = this.getSqlSession().selectList("categoryMapping.findByCid", cid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	// 删除一级分类
	@Override
	public void delete(Category category) {
		// 删除一级分类下的所有二级分类
		this.getSqlSession().delete("categoryMapping.deleteSecond", category);
		// 删除一级分类
		this.getSqlSession().delete("categoryMapping.delete", category);
		
	}

	// 更新一级分类
	@Override
	public void update(Category category) {
		this.getSqlSession().update("categoryMapping.update", category);
	}
}
