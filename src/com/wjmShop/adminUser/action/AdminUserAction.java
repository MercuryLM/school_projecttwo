package com.wjmShop.adminUser.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.adminUser.service.AdminUserService;
import com.wjmShop.bean.AdminUser;
import com.wjmShop.utils.BaseAction;

public class AdminUserAction extends BaseAction implements ModelDriven<AdminUser> {
	private static final long serialVersionUID = -6284052172641181752L;
	// 模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// 注入AdminUserService
	@Resource
	private AdminUserService adminUserService;

	// 后台登录的执行的方法
	public String login() {
		// 调用service方法完成登录
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// 判断
		if (existAdminUser == null) {
			// 用户名或密码错误
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		} else {
			// 登录成功:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
	
	// 后台退出的执行方法
	public String logout() {
		// 清除session
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
}
