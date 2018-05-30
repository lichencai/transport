package com.zriot.elicense.illegal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zriot.elicense.illegal.request.GetBillInfoListRequest;
import com.zriot.elicense.illegal.request.SaveOrUpdateBillRequest;
import com.zriot.elicense.illegal.response.BillInfoResponse;
import com.zriot.elicense.illegal.response.Response;
import com.zriot.elicense.illegal.service.BillService;
import com.zriot.elicense.illegal.util.JSONUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@PostMapping("/saveOrUpdateBill")
	public Response<String> saveOrUpdateBill(@RequestBody SaveOrUpdateBillRequest saveOrUpdateBillRequest) {
		log.info("saveOrUpdateBill params : {}", JSONUtils.beanToJSONString(saveOrUpdateBillRequest));
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		
		billService.saveOrUpdateBill(saveOrUpdateBillRequest, userDetails);
		return Response.successResponse("保存成功");
	}
	
	@PostMapping("/editBill")
	public Response<BillInfoResponse> editBill(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editBill params : {}", id);
		BillInfoResponse billInfoResponse = null;
		billInfoResponse = billService.findBillInfoById(Integer.parseInt(id));
		return Response.successResponse(billInfoResponse);
	}
	
	@PostMapping("/deleteBill")
	public Response<String> deleteBill(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editBill params : {}", id);
		boolean result = billService.deleteBill(Integer.parseInt(id));
		if(!result){
			Response.failResponse("删除失败");
		}
		return Response.successResponse("删除成功");
	}
	
	@PostMapping("/finshBill")
	public Response<String> finshBill(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editBill params : {}", id);
		boolean result = billService.finshBill(Integer.parseInt(id));
		if(!result){
			Response.failResponse("订单完成失败");
		}
		return Response.successResponse("订单完成成功");
	}
	
	@PostMapping("/getBillInfoList")
	public Response<List<BillInfoResponse>> getBillInfoList(@RequestBody GetBillInfoListRequest getBillInfoListRequest) {
		log.info("saveOrUpdateBill params : {}", JSONUtils.beanToJSONString(getBillInfoListRequest));
		List<BillInfoResponse> list = new ArrayList<BillInfoResponse>();
		
		
		
		
		return Response.successResponse(list);
	}
	
	
	
}
