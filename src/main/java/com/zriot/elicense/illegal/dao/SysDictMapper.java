package com.zriot.elicense.illegal.dao;


import java.util.List;

import com.zriot.elicense.illegal.model.SysDict;

public interface SysDictMapper {
	List<SysDict> findByType(String type);
}
