package com.zriot.elicense.illegal.model;

import java.util.Date;

public class BillInfo {
	private Integer id;
	private String billId;
	private Integer customerInfoId;
	private String customerName;
	private String productName;
	private String productPack;
	private Integer productNumber;
	private String fromAddress;
	private String toAddress;
	private String sender;
	private String senderMobile;
	private String senderIdentityCard;
	private String receiver;
	private String receiverMobile;
	private String receiverIdentityCard;
	private String carNo;
	private Date receiveDate;
	private Integer isFinshFee;
	private String handledBy;
	private String mark;
	private Date createDate;
	private Date updateDate;
	private Integer isFinshAll;
	private String creator;
	private String updateUser;
	private Integer deleteFlag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	public String getSenderIdentityCard() {
		return senderIdentityCard;
	}
	public void setSenderIdentityCard(String senderIdentityCard) {
		this.senderIdentityCard = senderIdentityCard;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public Integer getIsFinshFee() {
		return isFinshFee;
	}
	public void setIsFinshFee(Integer isFinshFee) {
		this.isFinshFee = isFinshFee;
	}
	public String getHandledBy() {
		return handledBy;
	}
	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Integer getIsFinshAll() {
		return isFinshAll;
	}
	public void setIsFinshAll(Integer isFinshAll) {
		this.isFinshAll = isFinshAll;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
