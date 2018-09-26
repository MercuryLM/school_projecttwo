package com.wjmShop.categorySecond.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.wjmShop.bean.CategorySecond;
import com.wjmShop.categorySecond.service.CategorySecondService;

@Service("categorySecondService")
public class CategorySecondServiceImpl extends SqlSessionDaoSupport implements CategorySecondService{

	// 查询一级分类下所有二级分类
	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySecond> findAll(Integer cid) {
		List<CategorySecond> list = this.getSqlSession().selectList("categorySecondMapping.findAll", cid);
		if(list != null && list.size() > 0)
		{
			return list;
		}else{
			return null;
		}
	}

	// 设置总页数
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		List<Integer> list = this.getSqlSession().selectList("categorySecondMapping.findCount");
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return 0;
	}

	// 分页方法的查询
	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySecond> findByPage(int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<CategorySecond> list = this.getSqlSession().selectList("categorySecondMapping.findByPage", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}

	// 添加二级分类
	@Override
	public void save(CategorySecond categorySecond) {
		this.getSqlSession().insert("categorySecondMapping.save", categorySecond);
		
	}

	// 删除二级分类
	@Override
	public void delete(CategorySecond categorySecond) {
		this.getSqlSession().delete("categorySecondMapping.delete", categorySecond);
	}

	// 业务层根据id查询二级分类
	@SuppressWarnings("unchecked")
	@Override
	public CategorySecond findByCsid(Integer csid) {
		List<CategorySecond> list = this.getSqlSession().selectList("categorySecondMapping.findByCsid", csid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	// 修改二级分类
	@Override
	public void update(CategorySecond categorySecond) {
		this.getSqlSession().update("categorySecondMapping.update", categorySecond);
		
	}

	// 查询所有二级分类
	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySecond> findAll() {
		List<CategorySecond> list = this.getSqlSession().selectList("categorySecondMapping.findSecondAll");
		if(list != null && list.size() > 0)
		{
			return list;
		}else{
			return null;
		}
	}
}
