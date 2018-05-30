package com.zriot.elicense.illegal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zriot.elicense.illegal.model.BillInfo;
import com.zriot.elicense.illegal.vo.BillListSearchResultVo;
import com.zriot.elicense.illegal.vo.BillListSearchVo;

@Repository
public interface BillInfoMapper {
	Integer insert(BillInfo billInfo);
	int update(BillInfo billInfo);
	int delete(Integer id);
	BillInfo searchById(Integer id);
	List<BillListSearchResultVo> searchBillList(BillListSearchVo vo);
	Integer countBillList(BillListSearchVo vo);
}
