package com.zriot.elicense.illegal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zriot.elicense.illegal.dao.IUserMapper;
import com.zriot.elicense.illegal.model.IUser;
import com.zriot.elicense.illegal.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private IUserMapper iUserMapper;

	public IUser findByLoginName(String loginName) {
		IUser iUser = null;
		iUser = iUserMapper.selectByLoginName(loginName);
		return iUser;
	}

	@Override
	public List<IUser> findByName(String name) {
		return iUserMapper.selectByName(name);
	}
}
