package com.zriot.elicense.illegal.request;

import java.util.Date;

public class GetBillInfoListRequest {
	private String customerName;
	private Integer isFinshAll;
	private Integer isFinshFee;
	private Integer pageNo;
	private Integer pageSize;
	private Date beginDate;
	private Date endDate;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getIsFinshAll() {
		return isFinshAll;
	}
	public void setIsFinshAll(Integer isFinshAll) {
		this.isFinshAll = isFinshAll;
	}
	public Integer getIsFinshFee() {
		return isFinshFee;
	}
	public void setIsFinshFee(Integer isFinshFee) {
		this.isFinshFee = isFinshFee;
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
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
