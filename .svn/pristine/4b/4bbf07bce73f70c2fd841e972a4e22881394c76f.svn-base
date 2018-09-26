package com.wjmShop.product.action;
import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wjmShop.bean.Category;
import com.wjmShop.bean.CategorySecond;
import com.wjmShop.bean.Product;
import com.wjmShop.category.service.CategoryService;
import com.wjmShop.categorySecond.service.CategorySecondService;
import com.wjmShop.product.service.ProductService;
import com.wjmShop.utils.BaseAction;
import com.wjmShop.utils.PageBean;

public class ProductAction extends BaseAction implements ModelDriven<Product>{
	
	private static final long serialVersionUID = -8001669217720195272L;
		// 用于接收数据的模型驱动.
		private Product product = new Product();
		// 注入商品的Service
		@Resource
		private ProductService productService;
		// 注入一级分类的Service
		@Resource
		private CategoryService categoryService;
		// 注入二级分类的Service
		@Resource
		private CategorySecondService categorySecondService;
		// 接收分类cid
		private Integer cid;
		// 接收当前页数:
		private int page;
		// 一级分类与二级分类List
		public List<Category> cList;
		
		// 根据商品的ID进行查询商品:执行方法:
		public String findByPid() {
			// 调用Service的方法完成查询.
			product = productService.findByPid(product.getPid());
			List<Category> clist = GetCategoryAllList();
			this.cList = clist;
			return "findByPid";
		}

		// 根据分类的id查询商品:
		public String findByCid() {
			List<Category> cList = GetCategoryAllList();
			this.cList = cList;
			PageBean<Product> pageBean = findByPageCid(cid, page);// 根据一级分类查询商品,带分页查询
			// 将PageBean存入到值栈中:
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByCid";
		}

		// 根据一级分类的cid带有分页查询商品
		public PageBean<Product> findByPageCid(Integer cid, int page) {
			PageBean<Product> pageBean = new PageBean<Product>();
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			int limit = 8;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = this.productService.findCountCid(cid);
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
			// 每页显示的数据集合:
			// 从哪开始:
			int begin = (page - 1) * limit;
			List<Product> list = this.productService.findByPageCid(cid, begin, limit);
			pageBean.setList(list);
			return pageBean;
		}
		
		
		// 根据二级分类id查询商品:
		public String findByCsid() {
			List<Category> cList = GetCategoryAllList();
			this.cList = cList;
			// 根据二级分类查询商品
			PageBean<Product> pageBean = findByPageCsid(product.getCsid(), page);
			// 将PageBean存入到值栈中:
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByCsid";
		}

		// 根据二级分类查询商品信息
		public PageBean<Product> findByPageCsid(Integer csid, int page) {
			PageBean<Product> pageBean = new PageBean<Product>();
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			int limit = 8;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = productService.findCountCsid(csid);
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
			// 每页显示的数据集合:
			// 从哪开始:
			int begin = (page - 1) * limit;
			List<Product> list = productService.findByPageCsid(csid, begin, limit);
			pageBean.setList(list);
			return pageBean;
		}
		
		//一级分类与二级分类List
		public List<Category> GetCategoryAllList(){
			List<Category> cList = categoryService.findAll();
			if(cList != null && cList.size() > 0){
				for(Category cInfo : cList){
					List<CategorySecond> csList = categorySecondService.findAll(cInfo.getCid());
					if(csList != null && csList.size() > 0){
						cInfo.setCategorySeconds(csList);
					}
				}
			}
			return cList;
		}
		
		public void setPage(int page) {
			this.page = page;
		}
		
		public void setCid(Integer cid) {
			this.cid = cid;
		}

		public void setProductService(ProductService productService) {
			this.productService = productService;
		}

		public Product getModel() {
			return product;
		}

		public List<Category> getcList() {
			return cList;
		}

		public void setcList(List<Category> cList) {
			this.cList = cList;
		}
}
