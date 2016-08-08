package com.dekan.mall.bean.common;

import java.util.List;

import org.apache.commons.lang.StringUtils;



/**
 * @ClassName Pager
 * @Description TODO【分页】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class Pager {
	
	public static final Integer MAX_PAGE_SIZE = 500;// 每页最大记录数限制

	// 排序方式（递增、递减）
	public enum Order {
		asc, desc
	}

	private int pageNumber = 1;// 当前页码
	private int pageSize = 30;// 每页记录数
	private String searchBy;// 查找字段
	private String keyword;// 查找关键字
	private String orderBy = "id";// 排序字段
	private Order order = Order.desc;// 排序方式 

	private long totalCount;// 总记录数
	private List<?> results;// 返回结果
	@SuppressWarnings("unused")
	private int pageCount = 1; //总页数
	private String fisrtId;//第一条记录ID;
	

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// 获取总页数
	public int getPageCount() {
		int pageCount = (int) (totalCount / pageSize);
		if (totalCount % pageSize > 0) {
			pageCount++;
		}
		if(pageCount == 0){
			pageCount = 1;
		}
		return pageCount;
	}
	
	public int getFirstIndex() {
		return (pageNumber - 1) * pageSize;
	}

	public int getPageNumber() {
		
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		if(pageNumber != null){
			if (pageNumber < 1) {
				pageNumber = 1;
			}
			this.pageNumber = pageNumber;
		}
	}
	
	public void setPageNumber(String pageNumber) {
		if(StringUtils.isNotBlank(pageNumber)){
			int number = Integer.parseInt(pageNumber);
			if (number < 1) {
				number = 1;
			}
			this.pageNumber = number;
		}
		
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize != null){
			if (pageSize < 1) {
				pageSize = 1;
			} else if (pageSize > MAX_PAGE_SIZE) {
				pageSize = MAX_PAGE_SIZE;
			}
			this.pageSize = pageSize;
		}
	}
	
	public void setPageSize(String pageSize) {
		if(StringUtils.isNotBlank(pageSize)){
			int size = Integer.parseInt(pageSize);
			if (size < 1) {
				size = 1;
			} else if (size > MAX_PAGE_SIZE) {
				size = MAX_PAGE_SIZE;
			}
			this.pageSize = size;
		}
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}

	public String getFisrtId() {
		return fisrtId;
	}

	public void setFisrtId(String fisrtId) {
		this.fisrtId = fisrtId;
	}
	
}
