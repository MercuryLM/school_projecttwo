package com.wjmShop.categoryThird.adminAction;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.Category;
import com.wjmShop.bean.CategorySecond;
import com.wjmShop.bean.CategoryThird;
import com.wjmShop.category.service.CategoryService;
import com.wjmShop.categorySecond.service.CategorySecondService;
import com.wjmShop.categoryThird.service.CategoryThirdService;
import com.wjmShop.utils.BaseAction;
import com.wjmShop.utils.PageBean;

/**
 * 后台三级分类的管理的Action.
 * 
 * @author
 * 
 */
public class AdminCategoryThirdAction extends BaseAction implements ModelDriven<CategoryThird> {

	private static final long serialVersionUID = -3366982898255571738L;
	// 模型驱动使用的对象
	private CategoryThird categoryThird = new CategoryThird();
	// 接收page参数:
	private Integer page;
	// 注入三级Service
	@Resource
	private CategoryThirdService categoryThirdService;
	// 注入二级分类的Service
	@Resource
	private CategorySecondService categorySecondService;

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategoryThirdService(
			CategoryThirdService categoryThirdService) {
		this.categoryThirdService = categoryThirdService;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public CategoryThird getModel() {
		return categoryThird;
	}

	// 带有分页的查询所有二级分类的操作:
	public String findAll() {
		// 调用Service进行查询.
		PageBean<CategoryThird> pageBean = this.findByPage(page);
		// 将pageBean的数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 二级分类带有分页的查询操作:
	public PageBean<CategoryThird> findByPage(Integer page) {
		PageBean<CategoryThird> pageBean = new PageBean<CategoryThird>();

		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = categoryThirdService.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置页面显示数据的集合:
		int begin = (page - 1) * limit;
		List<CategoryThird> list = categoryThirdService.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	// 跳转到添加页面的方法:
	public String addPage() {
		// 查询所有一级分类.
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转:
		return "addPage";
	}

	// 添加三级分类的方法:
	public String save() {
		categoryThirdService.save(categoryThird);
		return "saveSuccess";
	}

	// 删除三级分类的方法:
	public String delete() {
		categoryThirdService.delete(categoryThird);
		return "deleteSuccess";
	}

	// 编辑三级分类的方法:
	public String edit() {
		// 根据id查询二级分类:
		categoryThird = categoryThirdService.findByCtid(categoryThird.getCtid());
		// 查询所有一级分类:
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转:
		return "editSuccess";
	}
	
	// 修改三级分类的方法:
	public String update(){
		categoryThirdService.update(categoryThird);
		return "updateSuccess";
	}
}
