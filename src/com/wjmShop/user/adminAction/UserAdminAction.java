package com.wjmShop.user.adminAction;
import java.util.List;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.User;
import com.wjmShop.user.service.UserService;
import com.wjmShop.utils.BaseAction;
import com.wjmShop.utils.PageBean;
/**
 * 后台用户管理的Action类
 * @author
 *
 */
public class UserAdminAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = -8008668855822534438L;
	// 模型驱动使用的类
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// 注入用户的Service
	@Resource
	private UserService userService;
	
	// 接受page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 后台查询所有用户的方法带分页:
	public String findAll(){
		PageBean<User> pageBean = this.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	// 业务层用户查询所有
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userService.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<User> list = userService.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	// 后台用户的删除
	public String delete(){
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}
	
	// 后台用户的编辑
	public String edit(){
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}
	
	// 后台用户的修改:
	public String update(){
		userService.updateInfo(user);
		return "updateSuccess";
	}
}
