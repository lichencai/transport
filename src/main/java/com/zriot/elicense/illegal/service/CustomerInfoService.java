package com.zriot.elicense.illegal.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.zriot.elicense.illegal.model.CustomerInfo;
import com.zriot.elicense.illegal.request.GetCustomerInfoListRequest;
import com.zriot.elicense.illegal.response.GetCustomerInfoListResponse;

public interface CustomerInfoService {

	void saveOrUpdateCustomerInfo(CustomerInfo customerInfo, UserDetails userDetails);

	CustomerInfo findCustomerInfoById(int id);

	boolean deleteCustomerInfo(int id);

	GetCustomerInfoListResponse getCustomerInfoListInfo(GetCustomerInfoListRequest getCustomerInfoListRequest);

	List<CustomerInfo> getAllCustomerInfos();

}
