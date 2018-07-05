package com.zriot.elicense.illegal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zriot.elicense.illegal.model.CustomerInfo;
import com.zriot.elicense.illegal.vo.CustomerListSearchVo;

@Repository
public interface CustomerInfoMapper {
	Integer insert(CustomerInfo customerInfo);
	int update(CustomerInfo customerInfo);
	int delete(Integer id);
	CustomerInfo searchById(Integer id);
	List<CustomerInfo> searchCustomerList(CustomerListSearchVo vo);
	Integer countCustomerList(CustomerListSearchVo vo);
	List<CustomerInfo> getAllCustomerInfos();
}
