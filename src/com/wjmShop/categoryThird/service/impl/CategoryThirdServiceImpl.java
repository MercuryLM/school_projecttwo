package com.wjmShop.categoryThird.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.wjmShop.bean.CategoryThird;
import com.wjmShop.categoryThird.service.CategoryThirdService;

@Service("categoryThirdService")
public class CategoryThirdServiceImpl extends SqlSessionDaoSupport implements CategoryThirdService{

	// 查询一级分类下所有二级分类
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryThird> findAll(Integer csid) {
		List<CategoryThird> list = this.getSqlSession().selectList("categoryThirdMapping.findAll", csid);
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
		List<Integer> list = this.getSqlSession().selectList("categoryThirdMapping.findCount");
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return 0;
	}

	// 分页方法的查询
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryThird> findByPage(int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<CategoryThird> list = this.getSqlSession().selectList("categoryThirdMapping.findByPage", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}

	// 添加二级分类
	@Override
	public void save(CategoryThird categoryThird) {
		this.getSqlSession().insert("categoryThirdMapping.save", categoryThird);
		
	}

	// 删除二级分类
	@Override
	public void delete(CategoryThird categoryThird) {
		this.getSqlSession().delete("categoryThirdMapping.delete", categoryThird);
	}

	// 业务层根据id查询三级分类
	@SuppressWarnings("unchecked")
	@Override
	public CategoryThird findByCtid(Integer ctid) {
		List<CategoryThird> list = this.getSqlSession().selectList("categoryThirdMapping.findByCtid", ctid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	// 修改二级分类
	@Override
	public void update(CategoryThird categoryThird) {
		this.getSqlSession().update("categoryThirdMapping.update", categoryThird);
		
	}

	// 查询所有二级分类
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryThird> findAll() {
		List<CategoryThird> list = this.getSqlSession().selectList("categoryThirdMapping.findThirdAll");
		if(list != null && list.size() > 0)
		{
			return list;
		}else{
			return null;
		}
	}
}
