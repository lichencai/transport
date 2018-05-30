package com.zriot.elicense.illegal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zriot.elicense.illegal.model.BillDetailFeeInfo;

@Repository
public interface BillDetailFeeInfoMapper {
	Integer insert(BillDetailFeeInfo billDetailFeeInfo);
	int update(BillDetailFeeInfo billDetailFeeInfo);
	int delete(Integer id);
	List<BillDetailFeeInfo> searchByBillFeeId(Integer billFeeId);
}
