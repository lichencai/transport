package com.zriot.elicense.illegal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zriot.elicense.illegal.request.CreateRportRequest;
import com.zriot.elicense.illegal.response.CreateRportResponse;
import com.zriot.elicense.illegal.response.Response;
import com.zriot.elicense.illegal.service.ReportService;
import com.zriot.elicense.illegal.util.JSONUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 报表统计
 */
@Slf4j
@RestController
@RequestMapping(value="/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/createRport")
	public Response<CreateRportResponse> createRport(@RequestBody CreateRportRequest createRportRequest) {
		log.info("createRportRequest params : {}", JSONUtils.beanToJSONString(createRportRequest));
		CreateRportResponse response = reportService.createRport(createRportRequest);
		return Response.successResponse(response);
	}
	
}
