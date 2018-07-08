package com.zriot.elicense.illegal.vo;

public class CreateRportVo {
	private String customerName;	//  发货单位
	private String productName;		//货物
	private Integer productNumber;		//件数
	private Double kiloCount;		//公斤数
	private String receiver;		//收货单位
	private Double transportFee;		//运费
	private String feePayType;		//付款方式
	private Double collectionFee;		//代收货款
	private Double deliverFee;		//送货费
	private String mark;		//备注
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public Double getKiloCount() {
		return kiloCount;
	}
	public void setKiloCount(Double kiloCount) {
		this.kiloCount = kiloCount;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Double getTransportFee() {
		return transportFee;
	}
	public void setTransportFee(Double transportFee) {
		this.transportFee = transportFee;
	}
	public String getFeePayType() {
		return feePayType;
	}
	public void setFeePayType(String feePayType) {
		this.feePayType = feePayType;
	}
	public Double getCollectionFee() {
		return collectionFee;
	}
	public void setCollectionFee(Double collectionFee) {
		this.collectionFee = collectionFee;
	}
	public Double getDeliverFee() {
		return deliverFee;
	}
	public void setDeliverFee(Double deliverFee) {
		this.deliverFee = deliverFee;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
