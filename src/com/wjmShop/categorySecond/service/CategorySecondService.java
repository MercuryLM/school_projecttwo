package com.wjmShop.categorySecond.service;

import java.util.List;
import com.wjmShop.bean.CategorySecond;

/**
 * 二级分类的业务层对象
 * @author
 *
 */
public interface CategorySecondService {
	// 查询一级分类下所有的二级分类
	public List<CategorySecond> findAll(Integer cid);
	// 设置总页数
	public int findCount();
	// 设置页面显示数据的集合:
	public List<CategorySecond> findByPage(int begin, int limit);
	// 添加二级分类
	public void save (CategorySecond categorySecond);
	// 删除二级分类
	public void delete(CategorySecond categorySecond);
	// 业务层根据id查询二级分类
	public CategorySecond findByCsid(Integer csid);
	// 修改二级分类
	public void update(CategorySecond categorySecond);
	// 查询所有的二级分类
	public List<CategorySecond> findAll();
}
