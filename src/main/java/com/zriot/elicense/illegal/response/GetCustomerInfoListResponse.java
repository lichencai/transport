package com.zriot.elicense.illegal.response;

import java.util.List;

import com.zriot.elicense.illegal.model.CustomerInfo;

public class GetCustomerInfoListResponse {
	private List<CustomerInfo> vos;
	private Integer total;	//  总数
	private Integer totalPages;		// 总页数
	private Integer pageNo;
	private Integer pageSize;
	public List<CustomerInfo> getVos() {
		return vos;
	}
	public void setVos(List<CustomerInfo> vos) {
		this.vos = vos;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
