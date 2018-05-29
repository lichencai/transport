package com.zriot.elicense.illegal.dao;

import org.springframework.stereotype.Repository;

import com.zriot.elicense.illegal.model.BillFee;

@Repository
public interface BillFeeMapper {
	Integer insert(BillFee billFee);
	void update(BillFee billFee);
	BillFeeMapper searchByBillInfoId(Integer billInfoId);
}
