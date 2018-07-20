package com.zriot.elicense.illegal.service;

import com.zriot.elicense.illegal.request.CreateRportRequest;
import com.zriot.elicense.illegal.response.CreateRportResponse;

public interface ReportService {
	
	CreateRportResponse createRport(CreateRportRequest createRportRequest);
	
}
