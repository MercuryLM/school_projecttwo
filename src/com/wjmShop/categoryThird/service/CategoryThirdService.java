package com.wjmShop.categoryThird.service;

import java.util.List;
import com.wjmShop.bean.CategoryThird;

/**
 * 二级分类的业务层对象
 * @author
 *
 */
public interface CategoryThirdService {
	// 查询一级分类下所有的二级分类
	public List<CategoryThird> findAll(Integer csid);
	// 设置总页数
	public int findCount();
	// 设置页面显示数据的集合:
	public List<CategoryThird> findByPage(int begin, int limit);
	// 添加二级分类
	public void save (CategoryThird categoryThird);
	// 删除二级分类
	public void delete(CategoryThird categoryThird);
	// 业务层根据id查询二级分类
	public CategoryThird findByCtid(Integer ctid);
	
	// 修改二级分类
	public void update(CategoryThird categoryThird);
	// 查询所有的二级分类
	public List<CategoryThird> findAll();
}
