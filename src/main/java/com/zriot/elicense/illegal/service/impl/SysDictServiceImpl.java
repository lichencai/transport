package com.zriot.elicense.illegal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zriot.elicense.illegal.dao.SysDictMapper;
import com.zriot.elicense.illegal.model.SysDict;
import com.zriot.elicense.illegal.service.SysDictService;
/**
 * 系统字典查询
 */
@Service
public class SysDictServiceImpl implements SysDictService{
	
	@Autowired
	SysDictMapper sysDictMapper;
	
	public List<SysDict> findByType(String type){
		return sysDictMapper.findByType(type);
	}
	
}
