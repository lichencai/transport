package com.zriot.elicense.illegal.model;

import java.util.Date;

public class BillFee {
	private Integer id;
	private Integer billInfoId;
	private Double transportFee;
	private Double deliverFee;
	private Double shipmentFee;
	private Double chargeFee;
	private Double warehouseFee;
	private Double collectionFee;
	private Double insuranceFee;
	private Double otherFee;
	private Integer feePayType;
	private Double feeReceivable;
	private Double realCharge;
	private String updateUser;
	private Date updateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBillInfoId() {
		return billInfoId;
	}
	public void setBillInfoId(Integer billInfoId) {
		this.billInfoId = billInfoId;
	}
	public Double getTransportFee() {
		return transportFee;
	}
	public void setTransportFee(Double transportFee) {
		this.transportFee = transportFee;
	}
	public Double getDeliverFee() {
		return deliverFee;
	}
	public void setDeliverFee(Double deliverFee) {
		this.deliverFee = deliverFee;
	}
	public Double getShipmentFee() {
		return shipmentFee;
	}
	public void setShipmentFee(Double shipmentFee) {
		this.shipmentFee = shipmentFee;
	}
	public Double getChargeFee() {
		return chargeFee;
	}
	public void setChargeFee(Double chargeFee) {
		this.chargeFee = chargeFee;
	}
	public Double getWarehouseFee() {
		return warehouseFee;
	}
	public void setWarehouseFee(Double warehouseFee) {
		this.warehouseFee = warehouseFee;
	}
	public Double getCollectionFee() {
		return collectionFee;
	}
	public void setCollectionFee(Double collectionFee) {
		this.collectionFee = collectionFee;
	}
	public Double getInsuranceFee() {
		return insuranceFee;
	}
	public void setInsuranceFee(Double insuranceFee) {
		this.insuranceFee = insuranceFee;
	}
	public Double getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(Double otherFee) {
		this.otherFee = otherFee;
	}
	public Integer getFeePayType() {
		return feePayType;
	}
	public void setFeePayType(Integer feePayType) {
		this.feePayType = feePayType;
	}
	public Double getFeeReceivable() {
		return feeReceivable;
	}
	public void setFeeReceivable(Double feeReceivable) {
		this.feeReceivable = feeReceivable;
	}
	public Double getRealCharge() {
		return realCharge;
	}
	public void setRealCharge(Double realCharge) {
		this.realCharge = realCharge;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
