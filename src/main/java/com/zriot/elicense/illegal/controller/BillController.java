package com.zriot.elicense.illegal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zriot.elicense.illegal.request.GetBillInfoListRequest;
import com.zriot.elicense.illegal.request.SaveOrUpdateBillRequest;
import com.zriot.elicense.illegal.response.BillInfoResponse;
import com.zriot.elicense.illegal.response.Response;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.util.JSONUtils;

@Slf4j
@RestController
@RequestMapping(value="/bill")
public class BillController {
	
	@PostMapping("/saveOrUpdateBill")
	public Response<String> saveOrUpdateBill(@RequestBody SaveOrUpdateBillRequest saveOrUpdateBillRequest) {
		log.info("saveOrUpdateBill params : {}", JSONUtils.valueToString(saveOrUpdateBillRequest));
		
		
		
		
		return Response.successResponse("保存成功");
	}
	
	@PostMapping("/getBillInfoList")
	public Response<List<BillInfoResponse>> getBillInfoList(@RequestBody GetBillInfoListRequest getBillInfoListRequest) {
		log.info("saveOrUpdateBill params : {}", JSONUtils.valueToString(getBillInfoListRequest));
		
		
		
		List<BillInfoResponse> list = new ArrayList<BillInfoResponse>();
		
		
		
		
		return Response.successResponse(list);
	}
	
	
	
}
