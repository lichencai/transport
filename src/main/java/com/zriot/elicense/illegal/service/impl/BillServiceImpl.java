package com.zriot.elicense.illegal.service.impl;

import java.util.ArrayList;
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
import com.zriot.elicense.illegal.request.GetBillInfoListRequest;
import com.zriot.elicense.illegal.request.SaveOrUpdateBillRequest;
import com.zriot.elicense.illegal.response.BillInfoResponse;
import com.zriot.elicense.illegal.response.GetBillInfoListResponse;
import com.zriot.elicense.illegal.service.BillService;
import com.zriot.elicense.illegal.vo.BillListSearchResultVo;
import com.zriot.elicense.illegal.vo.BillListSearchVo;

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
			billInfo.setCreateDate(new Date());
			billInfo.setCreator(userDetails.getUsername());
			billInfo.setDeleteFlag(0);
			billInfo.setIsFinshAll(0);
			billInfoMapper.insert(billInfo);
		}else {
			billInfoMapper.update(billInfo);
		}
		
		billFee.setBillInfoId(billInfo.getId());
		if(billFee.getId() == null) {
			billFeeMapper.insert(billFee);
		}else {
			billFeeMapper.update(billFee);
		}
		
		List<BillDetailFeeInfo> old = billDetailFeeInfoMapper.searchByBillFeeId(billFee.getId());
		for(BillDetailFeeInfo each : old) {
			billDetailFeeInfoMapper.delete(each.getId());
		}
		
		for(BillDetailFeeInfo each : billDetailFeeInfos) {
			each.setBillFeeId(billFee.getId());
			each.setDeleteFlag(0);
			billDetailFeeInfoMapper.insert(each);
		}
		
		return true;
	}

	@Override
	public BillInfoResponse findBillInfoById(Integer id) {
		BillInfoResponse billInfoResponse = new BillInfoResponse();
		
		BillInfo billInfo = billInfoMapper.searchById(id);
		if(billInfo == null){
			throw new RuntimeException("根据id:" + id + "查询不到订单信息");
		}
		
		BillFee billFee = billFeeMapper.searchByBillInfoId(billInfo.getId());
		
		List<BillDetailFeeInfo> billDetailFeeInfos = billDetailFeeInfoMapper.searchByBillFeeId(billFee.getId());
		
		
		billInfoResponse.setBillInfo(billInfo);
		billInfoResponse.setBillFee(billFee);
		billInfoResponse.setBillDetailFeeInfos(billDetailFeeInfos);
		
		return billInfoResponse;
	}

	@Override
	public boolean deleteBill(Integer id) {
		BillInfo billInfo = new BillInfo();
		billInfo.setId(id);
		billInfo.setDeleteFlag(1);
		int result = billInfoMapper.update(billInfo);
		if(result == 0){
			return false;
		}
		return true;
	}

	@Override
	public boolean finshBill(Integer id) {
		BillInfo billInfo = new BillInfo();
		billInfo.setId(id);
		billInfo.setIsFinshAll(1);
		int result = billInfoMapper.update(billInfo);
		if(result == 0){
			return false;
		}
		return true;
	}

	@Override
	public GetBillInfoListResponse getBillListInfo(GetBillInfoListRequest getBillInfoListRequest) {
		GetBillInfoListResponse response = new GetBillInfoListResponse();
		
		BillListSearchVo billListSearchVo = new BillListSearchVo();
		
		billListSearchVo.setBeginDate(getBillInfoListRequest.getBeginDate());
		billListSearchVo.setCustomerName(getBillInfoListRequest.getCustomerName());
		billListSearchVo.setEndDate(getBillInfoListRequest.getEndDate());
		billListSearchVo.setIsFinshAll(getBillInfoListRequest.getIsFinshAll());
		billListSearchVo.setIsFinshFee(getBillInfoListRequest.getIsFinshFee());
		billListSearchVo.setPageSize(getBillInfoListRequest.getPageSize());
		
		Integer total = billInfoMapper.countBillList(billListSearchVo);
		if(total == 0){
			response.setPageNo(0);
			response.setTotal(0);
			response.setPageSize(getBillInfoListRequest.getPageSize());
			response.setTotalPages(0);
			response.setVos(new ArrayList<BillListSearchResultVo>());
			return response;
		}
		
		Integer beginNo = (getBillInfoListRequest.getPageNo() - 1) * getBillInfoListRequest.getPageSize();
		if(beginNo > total){
			beginNo = total;
		}
		billListSearchVo.setBeginNo(beginNo);
		
		List<BillListSearchResultVo> vos = billInfoMapper.searchBillList(billListSearchVo);
		
		response.setPageNo(getBillInfoListRequest.getPageNo());
		response.setTotal(total);
		response.setPageSize(getBillInfoListRequest.getPageSize());
		response.setTotalPages(getIntDivide(total, getBillInfoListRequest.getPageSize()));
		response.setVos(vos);
		
		return response;
	}
	
	private int getIntDivide(int a, int b){
		int c = a / b;
		if(a % b != 0){
			c++;
		}
		return c;
	}
	
	

}
