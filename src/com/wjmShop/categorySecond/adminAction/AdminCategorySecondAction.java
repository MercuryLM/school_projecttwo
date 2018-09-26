package com.wjmShop.categorySecond.adminAction;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.Category;
import com.wjmShop.bean.CategorySecond;
import com.wjmShop.category.service.CategoryService;
import com.wjmShop.categorySecond.service.CategorySecondService;
import com.wjmShop.utils.BaseAction;
import com.wjmShop.utils.PageBean;

/**
 * 后台二级分类的管理的Action.
 * 
 * @author
 * 
 */
public class AdminCategorySecondAction extends BaseAction implements ModelDriven<CategorySecond> {

	private static final long serialVersionUID = -3366982898255571738L;
	// 模型驱动使用的对象
	private CategorySecond categorySecond = new CategorySecond();
	// 接收page参数:
	private Integer page;
	// 注入二级Service
	@Resource
	private CategorySecondService categorySecondService;
	// 注入一级分类的Service
	@Resource
	private CategoryService categoryService;

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategorySecond getModel() {
		return categorySecond;
	}

	// 带有分页的查询所有二级分类的操作:
	public String findAll() {
		// 调用Service进行查询.
		PageBean<CategorySecond> pageBean = this.findByPage(page);
		// 将pageBean的数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 二级分类带有分页的查询操作:
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();

		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = categorySecondService.findCount();
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
		List<CategorySecond> list = categorySecondService.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	// 跳转到添加页面的方法:
	public String addPage() {
		// 查询所有一级分类.
		List<Category> cList = categoryService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// 页面跳转:
		return "addPage";
	}

	// 添加二级分类的方法:
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}

	// 删除二级分类的方法:
	public String delete() {
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}

	// 编辑二级分类的方法:
	public String edit() {
		// 根据id查询二级分类:
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		// 查询所有一级分类:
		List<Category> cList = categoryService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// 页面跳转:
		return "editSuccess";
	}
	
	// 修改二级分类的方法:
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
