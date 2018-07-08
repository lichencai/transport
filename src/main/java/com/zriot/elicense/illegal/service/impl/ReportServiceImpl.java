package com.zriot.elicense.illegal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zriot.elicense.illegal.dao.BillDetailFeeInfoMapper;
import com.zriot.elicense.illegal.dao.BillInfoMapper;
import com.zriot.elicense.illegal.model.BillDetailFeeInfo;
import com.zriot.elicense.illegal.request.CreateRportRequest;
import com.zriot.elicense.illegal.response.CreateRportResponse;
import com.zriot.elicense.illegal.service.ReportService;
import com.zriot.elicense.illegal.vo.BillListSearchResultVo;
import com.zriot.elicense.illegal.vo.BillListSearchVo;
import com.zriot.elicense.illegal.vo.CreateRportVo;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private BillInfoMapper billInfoMapper;
	
	@Autowired
	private BillDetailFeeInfoMapper billDetailFeeInfoMapper;
	
	@Override
	public CreateRportResponse createRport(CreateRportRequest createRportRequest) {
		
		BillListSearchVo billListSearchVo = new BillListSearchVo();
		
		billListSearchVo.setBeginDate(createRportRequest.getBeginDate());
		billListSearchVo.setEndDate(createRportRequest.getEndDate());
		
		List<BillListSearchResultVo> vos = billInfoMapper.reportList(billListSearchVo);
		
		CreateRportResponse response = new CreateRportResponse();
		
		List<CreateRportVo> createRportVos = new ArrayList<CreateRportVo>();
		Integer totalProductNumber = 0;		//  总件数
		Double totalKiloCount = 0.0;		//总公斤数
		Double totalTransportFee = 0.0;		//总运费
		Double totalCollectionFee = 0.0;		//总代收货款
		Double totalDeliverFee = 0.0;		//总送货费
		
		for(BillListSearchResultVo vo : vos) {
			List<BillDetailFeeInfo> billDetailFeeInfos = billDetailFeeInfoMapper.searchByBillFeeId(vo.getBillFeeId());
			CreateRportVo each = new CreateRportVo();
			boolean flag = false;
			for(BillDetailFeeInfo billDetailFeeInfo : billDetailFeeInfos) {
				if(billDetailFeeInfo.getType() == 1) {
					each.setKiloCount(billDetailFeeInfo.getUnit());
					totalKiloCount += billDetailFeeInfo.getUnit();
					flag = true;
					break;
				}
			}
			if(!flag) {
				each.setKiloCount(0.0);
			}
			
			each.setCollectionFee(vo.getCollectionFee());
			totalCollectionFee += vo.getCollectionFee();
			each.setDeliverFee(vo.getDeliverFee());
			totalDeliverFee += vo.getDeliverFee();
			each.setProductNumber(vo.getProductNumber());
			totalProductNumber += vo.getProductNumber();
			each.setTransportFee(vo.getTransportFee());
			totalTransportFee += vo.getTransportFee();
			
			each.setCustomerName(vo.getCustomerName());
			
			if(vo.getFeePayType() == 1) {
				each.setFeePayType("月结");
			}else if(vo.getFeePayType() == 2) {
				each.setFeePayType("提付");
			}else if(vo.getFeePayType() == 3) {
				each.setFeePayType("现付");
			}else if(vo.getFeePayType() == 4) {
				each.setFeePayType("回单付");
			}
			
			each.setMark(vo.getMark());
			each.setProductName(vo.getProductName());
			each.setReceiver(vo.getReceiver());
			
			createRportVos.add(each);
		}
		
		response.setCreateRportVos(createRportVos);
		response.setTotalCollectionFee(totalCollectionFee);
		response.setTotalDeliverFee(totalDeliverFee);
		response.setTotalKiloCount(totalKiloCount);
		response.setTotalProductNumber(totalProductNumber);
		response.setTotalTransportFee(totalTransportFee);
		
		return response;
	}

}
