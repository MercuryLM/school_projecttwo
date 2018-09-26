package com.wjmShop.user.service;

import java.util.List;
import com.wjmShop.bean.User;

public interface UserService {
	// 按用户查询用户的方法
	public User findByUsername(String username);
	// 业务层完成用户注册
	public void save(User user) throws Exception;
	// 业务层根据激活码查询用户
	public User findByCode(String code);
	// 修改用户状态的方法
	public void update(User user) throws Exception;
	// 登录的方法
	public User login(User user);
	// 设置总页数
	public int findCount();
	// 每页显示的数据集合
	public List<User> findByPage(int begin, int limit);
	// 获取用户信息
	public User findByUid(Integer uid);
	// 删除用户
	public void delete(User existUser);
	// 后台用户修改
	public void updateInfo(User user);
}
