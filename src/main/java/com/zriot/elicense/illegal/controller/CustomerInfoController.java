package com.zriot.elicense.illegal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zriot.elicense.illegal.model.CustomerInfo;
import com.zriot.elicense.illegal.request.GetCustomerInfoListRequest;
import com.zriot.elicense.illegal.response.GetCustomerInfoListResponse;
import com.zriot.elicense.illegal.response.Response;
import com.zriot.elicense.illegal.service.CustomerInfoService;
import com.zriot.elicense.illegal.util.JSONUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/customer")
public class CustomerInfoController {
	
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@PostMapping("/saveOrUpdateCustomerInfo")
	public Response<String> saveOrUpdateCustomerInfo(@RequestBody CustomerInfo customerInfo) {
		log.info("saveOrUpdateCustomerInfo params : {}", JSONUtils.beanToJSONString(customerInfo));
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		
		customerInfoService.saveOrUpdateCustomerInfo(customerInfo, userDetails);
		
		return Response.successResponse("保存成功");
	}
	
	@PostMapping("/editCustomerInfo")
	public Response<CustomerInfo> editCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("editCustomerInfo params : {}", id);
		CustomerInfo customerInfo = null;
		customerInfo = customerInfoService.findCustomerInfoById(Integer.parseInt(id));
		return Response.successResponse(customerInfo);
	}
	
	@PostMapping("/deleteCustomerInfo")
	public Response<String> deleteCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		log.info("deleteCustomerInfo params : {}", id);
		boolean result = customerInfoService.deleteCustomerInfo(Integer.parseInt(id));
		if(!result){
			Response.failResponse("删除失败");
		}
		return Response.successResponse("删除成功");
	}
	
	@PostMapping("/getCustomerInfoList")
	public Response<GetCustomerInfoListResponse> getCustomerInfoList(@RequestBody GetCustomerInfoListRequest getCustomerInfoListRequest) {
		log.info("getCustomerInfoList params : {}", JSONUtils.beanToJSONString(getCustomerInfoListRequest));
		GetCustomerInfoListResponse response = customerInfoService.getCustomerInfoListInfo(getCustomerInfoListRequest);
		return Response.successResponse(response);
	}
}
