package com.wjmShop.adminUser.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wjmShop.adminUser.dao.AdminUserDao;
import com.wjmShop.bean.AdminUser;

@Service("adminUserService")
@Transactional
public class AdminUserService {
	// 注入Dao
	@Resource
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
