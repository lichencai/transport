package com.zriot.elicense.illegal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zriot.elicense.illegal.dao.BillInfoMapper;
import com.zriot.elicense.illegal.model.BillInfo;
import com.zriot.elicense.illegal.request.GetBillInfoListRequest;
import com.zriot.elicense.illegal.request.SaveOrUpdateBillRequest;
import com.zriot.elicense.illegal.response.BillInfoResponse;
import com.zriot.elicense.illegal.response.Response;
import com.zriot.elicense.illegal.util.JSONUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/bill")
public class BillController {
	
	
	@Autowired
	private BillInfoMapper billInfoMapper;
	
	
	@PostMapping("/saveOrUpdateBill")
	public Response<String> saveOrUpdateBill(@RequestBody SaveOrUpdateBillRequest saveOrUpdateBillRequest) {
		log.info("saveOrUpdateBill params : {}", JSONUtils.beanToJSONString(saveOrUpdateBillRequest));
		
		BillInfo billInfo = new BillInfo();
		billInfo.setUpdateDate(new Date());
		billInfo.setBillId("123123");
		billInfoMapper.insert(billInfo);
		
		billInfo.setCarNo("粤A123");
		billInfo.setCreateDate(new Date());
		billInfo.setCustomerName("lichencai");
		billInfo.setId(3);
		billInfoMapper.update(billInfo);
		
		billInfoMapper.delete(4);
		
		BillInfo billInfoTemp = billInfoMapper.searchById(3);
		log.info(JSONUtils.beanToJSONString(billInfoTemp));
		
		return Response.successResponse("保存成功");
	}
	
	@PostMapping("/editBill")
	public Response<BillInfoResponse> editBill(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editBill params : {}", id);
		BillInfoResponse billInfoResponse = null;
		
		
		return Response.successResponse(billInfoResponse);
	}
	
	@PostMapping("/deleteBill")
	public Response<String> deleteBill(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editBill params : {}", id);
		BillInfoResponse billInfoResponse = null;
		
		
		return Response.successResponse("");
	}
	
	@PostMapping("/finshBill")
	public Response<String> finshBill(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editBill params : {}", id);
		BillInfoResponse billInfoResponse = null;
		
		
		return Response.successResponse("");
	}
	
	
	
	
	@PostMapping("/getBillInfoList")
	public Response<List<BillInfoResponse>> getBillInfoList(@RequestBody GetBillInfoListRequest getBillInfoListRequest) {
		log.info("saveOrUpdateBill params : {}", JSONUtils.beanToJSONString(getBillInfoListRequest));
		List<BillInfoResponse> list = new ArrayList<BillInfoResponse>();
		
		
		
		
		return Response.successResponse(list);
	}
	
	
	
}
