package com.zriot.elicense.illegal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zriot.elicense.illegal.dao.CustomerInfoMapper;
import com.zriot.elicense.illegal.model.CustomerInfo;
import com.zriot.elicense.illegal.request.GetCustomerInfoListRequest;
import com.zriot.elicense.illegal.response.GetCustomerInfoListResponse;
import com.zriot.elicense.illegal.service.CustomerInfoService;
import com.zriot.elicense.illegal.vo.CustomerListSearchVo;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService{

	
	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	
	
	@Override
	@Transactional
	public void saveOrUpdateCustomerInfo(CustomerInfo customerInfo, UserDetails userDetails) {
		
		String userName = userDetails.getUsername();
		
		customerInfo.setUpdateDate(new Date());
		customerInfo.setUpdateUser(userName);
		if(customerInfo.getId() == null){
			customerInfo.setCreateDate(new Date());
			customerInfo.setCreator(userName);
			customerInfo.setDeleteFlag(0);
			customerInfoMapper.insert(customerInfo);
		}else{
			customerInfoMapper.update(customerInfo);
		}
		
	}

	@Override
	public CustomerInfo findCustomerInfoById(int id) {
		CustomerInfo customerInfo = customerInfoMapper.searchById(id);
		return customerInfo;
	}

	@Override
	public boolean deleteCustomerInfo(int id) {
		int result = customerInfoMapper.delete(id);
		if(result == 0){
			return false;
		}
		return true;
	}

	@Override
	public GetCustomerInfoListResponse getCustomerInfoListInfo(GetCustomerInfoListRequest getCustomerInfoListRequest) {
		
		GetCustomerInfoListResponse response = new GetCustomerInfoListResponse();
		
		CustomerListSearchVo vo = new CustomerListSearchVo();
		
		vo.setBeginDate(getCustomerInfoListRequest.getBeginDate());
		vo.setCustomerName(getCustomerInfoListRequest.getCustomerName());
		vo.setEndDate(getCustomerInfoListRequest.getEndDate());
		vo.setPageSize(getCustomerInfoListRequest.getPageSize());
		
		Integer total = customerInfoMapper.countCustomerList(vo);
		if(total == 0){
			response.setPageNo(0);
			response.setTotal(0);
			response.setPageSize(getCustomerInfoListRequest.getPageSize());
			response.setTotalPages(0);
			response.setVos(new ArrayList<CustomerInfo>());
			return response;
		}
		
		Integer beginNo = (getCustomerInfoListRequest.getPageNo() - 1) * getCustomerInfoListRequest.getPageSize();
		if(beginNo > total){
			beginNo = total;
		}
		vo.setBeginNo(beginNo);
		
		List<CustomerInfo> vos = customerInfoMapper.searchCustomerList(vo);
		
		response.setPageNo(getCustomerInfoListRequest.getPageNo());
		response.setTotal(total);
		response.setPageSize(getCustomerInfoListRequest.getPageSize());
		response.setTotalPages(getIntDivide(total, getCustomerInfoListRequest.getPageSize()));
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

	@Override
	public List<CustomerInfo> getAllCustomerInfos() {
		return customerInfoMapper.getAllCustomerInfos();
	}
	
}
