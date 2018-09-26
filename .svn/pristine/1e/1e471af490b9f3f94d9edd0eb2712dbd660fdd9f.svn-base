package com.wjmShop.user.action;

import java.io.IOException;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.User;
import com.wjmShop.category.service.CategoryService;
import com.wjmShop.user.service.UserService;
import com.wjmShop.utils.MailUitls;
import com.wjmShop.utils.BaseAction;

public class UserAction extends BaseAction implements ModelDriven<User>{

	private static final long serialVersionUID = 4067622141332715241L;
	// 模型驱动使用的对象
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// 接收验证码:
	private String checkcode;
	
	private boolean resultFlg = false;
	
	// 注入UserService
	@Resource
	private UserService userService;

	/**
	 * 跳转到注册页面的执行方法
	 */
	public String registPage () {
		//userService.addUser(user);
		return "registPage";
	}

	/**
	 * AJAX进行异步校验用户名的执行方法
	 * 
	 * @throws IOException
	 */
	public String findByName() throws IOException {
		// 调用Service进行查询:
		User existUser = userService.findByUsername(user.getUsername());
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			this.resultFlg = true;
		} 
		return SUCCESS;
	}

	/**
	 * 用户注册的方法:
	 */
	public String regist() throws Exception{
		// 判断验证码程序:
		// 从session中获得验证码的随机值:
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码输入错误!");
			return "checkcodeFail";
		}
		userService.save(user);	
		MailUitls.sendMail(user.getEmail(), user.getCode());
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}
	
	/**
	 * 用户激活的方法
	 */
	public String active() throws Exception{
		// 根据激活码查询用户:
		User existUser = userService.findByCode(user.getCode());
		// 判断
		if (existUser == null) {
			// 激活码错误的
			this.addActionMessage("激活失败:激活码错误!");
		} else {
			// 激活成功
			// 修改用户的状态
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "msg";
	}
	
	/**
	 * 跳转到登录页面
	 */
	public String loginPage() {
		return "loginPage";
	}
	
	/**
	 * 登录的方法
	 */
	public String login() {
		User existUser = userService.login(user);
		// 判断
		if (existUser == null) {
			// 登录失败
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return LOGIN;
		} else {
			// 登录成功
			// 将用户的信息存入到session中
			session.put("existUser", existUser);
			// 页面跳转
			return "loginSuccess";
		}
	
	}
	
	/**
	 * 用户退出的方法
	 */
	public String quit(){
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public boolean isResultFlg() {
		return resultFlg;
	}

	public void setResultFlg(boolean resultFlg) {
		this.resultFlg = resultFlg;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
}
