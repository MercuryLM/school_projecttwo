package com.wjmShop.user.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.wjmShop.bean.Product;
import com.wjmShop.bean.User;
import com.wjmShop.user.service.UserService;
import com.wjmShop.utils.UUIDUtils;

@Service("userService")
public class UserServiceImpl extends SqlSessionDaoSupport implements UserService  {
	
	// 按名次查询是否有该用户:
	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String username) {
		List<User> list = this.getSqlSession().selectList("userMapping.findByUser", username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 注册用户存入数据库代码
	@Override
	public void save(User user) throws Exception{
		// 0代表用户未激活，1代表用户已激活
		user.setState(0);
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		this.getSqlSession().insert("userMapping.userSave", user);
	}

	// 根据激活码查询用户
	@SuppressWarnings("unchecked")
	@Override
	public User findByCode(String code) {
		List<User> list = this.getSqlSession().selectList("userMapping.findByCode", code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	// 修改用户状态的方法
	@Override
	public void update(User user) throws Exception{
		this.getSqlSession().update("userMapping.updateState", user);
	}

	// 用户登录的方法
	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) {
		user.setState(1);
		List<User> list = this.getSqlSession().selectList("userMapping.login", user);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 设置总页数
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		List<Integer> list = this.getSqlSession().selectList("userMapping.findCount");
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return 0;
	}

	// 每页显示的数据集合
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByPage(int begin, int limit) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("begin", begin);
		paramMap.put("limit", limit);
		List<User> list =  this.getSqlSession().selectList("userMapping.findByPage", paramMap);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	// 获取用户信息
	@SuppressWarnings("unchecked")
	@Override
	public User findByUid(Integer uid) {
		List<User> list = this.getSqlSession().selectList("userMapping.findByUid", uid);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 删除用户
	@Override
	public void delete(User existUser) {
		this.getSqlSession().delete("userMapping.userDelete", existUser);
	}

	// 更新用户信息
	@Override
	public void updateInfo(User user) {
		this.getSqlSession().update("userMapping.userUpdate", user);
		
	}
	
}
