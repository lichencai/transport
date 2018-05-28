package com.zriot.elicense.illegal.service;

import java.util.List;

import com.zriot.elicense.illegal.model.SysDict;
/**
 * 系统字典查询
 */
public interface SysDictService {
	public List<SysDict> findByType(String type);
}
