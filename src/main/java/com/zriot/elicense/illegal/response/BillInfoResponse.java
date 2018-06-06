package com.zriot.elicense.illegal.response;

import java.util.List;

import com.zriot.elicense.illegal.model.BillDetailFeeInfo;
import com.zriot.elicense.illegal.model.BillFee;
import com.zriot.elicense.illegal.model.BillInfo;
import com.zriot.elicense.illegal.model.CustomerInfo;

public class BillInfoResponse {
	private BillInfo billInfo;
	private BillFee billFee;
	private CustomerInfo customerInfo;
	private List<BillDetailFeeInfo> billDetailFeeInfos;
	public BillInfo getBillInfo() {
		return billInfo;
	}
	public void setBillInfo(BillInfo billInfo) {
		this.billInfo = billInfo;
	}
	public BillFee getBillFee() {
		return billFee;
	}
	public void setBillFee(BillFee billFee) {
		this.billFee = billFee;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public List<BillDetailFeeInfo> getBillDetailFeeInfos() {
		return billDetailFeeInfos;
	}
	public void setBillDetailFeeInfos(List<BillDetailFeeInfo> billDetailFeeInfos) {
		this.billDetailFeeInfos = billDetailFeeInfos;
	}
}
