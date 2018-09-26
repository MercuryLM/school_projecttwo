package com.wjmShop.adminUser.dao;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import com.wjmShop.bean.AdminUser;

@Service("adminUserDao")
public class AdminUserDao extends SqlSessionDaoSupport{

	// Dao完成登录的代码
	@SuppressWarnings("unchecked")
	public AdminUser login(AdminUser adminUser) {
		List<AdminUser> list = this.getSqlSession().selectList("adminUserMapping.login", adminUser);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
