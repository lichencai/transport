package com.zriot.elicense.illegal.request;

import java.util.Date;

public class CreateRportRequest {
	private Date beginDate;
	private Date endDate;
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
