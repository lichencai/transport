package com.zriot.elicense.illegal.dao;

import org.springframework.stereotype.Repository;

import com.zriot.elicense.illegal.model.BillInfo;

@Repository
public interface BillInfoMapper {
	Integer insert(BillInfo billInfo);
	void update(BillInfo billInfo);
	void delete(Integer id);
	BillInfo searchById(Integer id);
//	List<BillInfo> searchByParams();
}
