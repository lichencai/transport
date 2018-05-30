package com.zriot.elicense.illegal.vo;

import java.util.Date;

public class BillListSearchVo {
	private String  customerName;
	private Integer isFinshAll;
	private Integer isFinshFee;
	private Integer beginNo;
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
	public Integer getBeginNo() {
		return beginNo;
	}
	public void setBeginNo(Integer beginNo) {
		this.beginNo = beginNo;
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
