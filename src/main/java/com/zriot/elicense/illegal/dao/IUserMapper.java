package com.zriot.elicense.illegal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zriot.elicense.illegal.model.IUser;

@Repository
public interface IUserMapper {
	IUser selectByLoginName(String loginName);
	List<IUser> selectByName(String name);
}
