package com.wjmShop.product.adminAction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.CategorySecond;
import com.wjmShop.bean.Product;
import com.wjmShop.categorySecond.service.CategorySecondService;
import com.wjmShop.order.service.OrderService;
import com.wjmShop.product.service.ProductService;
import com.wjmShop.utils.BaseAction;
import com.wjmShop.utils.PageBean;

/**
 * 后台商品管理的Action
 * 
 * @author
 * 
 */
public class AdminProductAction extends BaseAction implements ModelDriven<Product> {
	private static final long serialVersionUID = -9205484333060892296L;
	// 模型驱动使用的对象
	private Product product = new Product();

	public Product getModel() {
		return product;
	}

	// 接收page参数
	private Integer page;

	// 商品pid
	private Integer pidValue;
	
	public boolean isExist = false;
	
	// 注入ProductService
	@Resource
	private ProductService productService;

	// 注入CategorySecondService
	@Resource
	private CategorySecondService categorySecondService;

	// 注入OrderService
	@Resource
	private OrderService orderService;
		
	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// 文件上传需要的三个属性:
	private File upload; // 上传文件
	private String uploadFileName; //接受文件上传的文件名
	private String uploadContentType;  //接受文件上传的文件的mime的类型

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// 查询所有的商品:
	public String findAll() {
		PageBean<Product> pageBean = this.findByPage(page);
		// 将PageBean数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

	// 后台查询所有商品带分页
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productService.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:findByPage
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productService.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	
	// 跳转到添加页面的方法:
	public String addPage() {
		// 查询所有的二级分类:
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将二级分类的数据显示到页面上
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转
		return "addPageSuccess";
	}

	// 保存商品的方法:
	public String save() throws IOException {
		// 将提交的数据添加到数据库中.
		product.setPdate(new Date());
		// product.setImage(image);
		if(upload != null){
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);
	
			product.setImage("products/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}

	// 校验所要删除的商品是否在订单项里存在
	public String selectOrderitem() throws IOException{
		int count  = orderService.selectOrderitem(pidValue);
		if(count > 0){
			this.isExist = true;
		}
		return SUCCESS;
	}
	
	// 删除商品的方法:
	public String delete() {
		// 根据id查询商品信息
		product = productService.findByPid(product.getPid());
		// 删除商品的图片:
		String path = ServletActionContext.getServletContext().getRealPath(
				"/" + product.getImage());
		File file = new File(path);
		file.delete();
		// 删除数据库中商品记录:
		productService.delete(product);
		// 页面跳转
		return "deleteSuccess";
	}

	// 编辑商品的方法
	public String edit() {
		// 根据商品id查询商品信息
		product = productService.findByPid(product.getPid());
		// 查询所有二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转到编辑页面:
		return "editSuccess";
	}

	// 修改商品的方法
	public String update() throws IOException {
		// 将信息修改到数据库
		product.setPdate(new Date());
		
		// 上传:
		if(upload != null ){
			String delPath = ServletActionContext.getServletContext().getRealPath(
					"/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		//productService.update(product);
		// 页面跳转
		return "updateSuccess";
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPidValue() {
		return pidValue;
	}

	public void setPidValue(Integer pidValue) {
		this.pidValue = pidValue;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
}
