package com.wjmShop.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一级分类的实体类对象
 * @author
 *
 */
public class Category implements Serializable{
	private static final long serialVersionUID = 8714790571075344876L;
	private Integer cid;
	private String cname;
	// 一级分类中存放二级分类的集合:
	private List<CategorySecond> categorySeconds = new ArrayList<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
}
