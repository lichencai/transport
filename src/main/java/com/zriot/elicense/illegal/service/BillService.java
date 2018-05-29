package com.zriot.elicense.illegal.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.zriot.elicense.illegal.request.SaveOrUpdateBillRequest;
import com.zriot.elicense.illegal.response.BillInfoResponse;

public interface BillService {
	/**
	 * 保存或更新订单信息
	 */
	public boolean saveOrUpdateBill(SaveOrUpdateBillRequest saveOrUpdateBillRequest, UserDetails userDetails);
	/**
	 * 根据订单id,查询订单信息
	 */
	public BillInfoResponse findBillInfoById(Integer id);
	/**
	 * 根据订单id,删除订单
	 */
	public boolean deleteBill(Integer id);
	/**
	 * 根据订单id,完成订单
	 */
	public boolean finshBill(Integer id);
}
