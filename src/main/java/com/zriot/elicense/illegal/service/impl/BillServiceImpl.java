package com.zriot.elicense.illegal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zriot.elicense.illegal.dao.BillDetailFeeInfoMapper;
import com.zriot.elicense.illegal.dao.BillFeeMapper;
import com.zriot.elicense.illegal.dao.BillInfoMapper;
import com.zriot.elicense.illegal.model.BillDetailFeeInfo;
import com.zriot.elicense.illegal.model.BillFee;
import com.zriot.elicense.illegal.model.BillInfo;
import com.zriot.elicense.illegal.request.SaveOrUpdateBillRequest;
import com.zriot.elicense.illegal.response.BillInfoResponse;
import com.zriot.elicense.illegal.service.BillService;

@Service
public class BillServiceImpl implements BillService{

	
	@Autowired
	private BillInfoMapper billInfoMapper;
	
	@Autowired
	private BillFeeMapper billFeeMapper;
	
	@Autowired
	private BillDetailFeeInfoMapper billDetailFeeInfoMapper;
	
	
	
	@Override
	@Transactional
	public boolean saveOrUpdateBill(SaveOrUpdateBillRequest saveOrUpdateBillRequest, UserDetails userDetails) {
		
		List<BillDetailFeeInfo> billDetailFeeInfos = saveOrUpdateBillRequest.getBillDetailFeeInfos();
		BillFee billFee = saveOrUpdateBillRequest.getBillFee();
		BillInfo billInfo = saveOrUpdateBillRequest.getBillInfo();
		
		billInfo.setUpdateDate(new Date());
		billInfo.setUpdateUser(userDetails.getUsername());
		if(billInfo.getId() == null) {
			billInfoMapper.insert(billInfo);
		}else {
			billInfoMapper.update(billInfo);
		}
		
		billFee.setUpdateDate(new Date());
		billFee.setUpdateUser(userDetails.getUsername());
		billFee.setBillInfoId(billInfo.getId());
		if(billFee.getId() == null) {
			billFeeMapper.insert(billFee);
		}else {
			billFeeMapper.update(billFee);
		}
		
		if(billFee.getId() != null) {
			List<BillDetailFeeInfo> old = billDetailFeeInfoMapper.searchByBillFeeId(billFee.getId());
			for(BillDetailFeeInfo each : old) {
				billDetailFeeInfoMapper.delete(each.getId());
			}
		}
		
		for(BillDetailFeeInfo each : billDetailFeeInfos) {
			each.setBillFeeId(billFee.getId());
			each.setUpdateDate(new Date());
			each.setUpdateUser(userDetails.getUsername());
			billDetailFeeInfoMapper.insert(each);
		}
		
		
		
		return false;
	}

	@Override
	public BillInfoResponse findBillInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBill(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finshBill(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
