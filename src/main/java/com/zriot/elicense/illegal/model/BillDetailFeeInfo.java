package com.zriot.elicense.illegal.model;

public class BillDetailFeeInfo {
	private Integer id;
	private Integer billFeeId;
	private Integer type;
	private Double unit;
	private Double fee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBillFeeId() {
		return billFeeId;
	}
	public void setBillFeeId(Integer billFeeId) {
		this.billFeeId = billFeeId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Double getUnit() {
		return unit;
	}
	public void setUnit(Double unit) {
		this.unit = unit;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
}
