/**
 * 
 */
package com.zriot.elicense.illegal.service;

import java.util.List;

import com.zriot.elicense.illegal.model.IUser;

/**
 * @author fangyunhe
 *
 * 2017年11月23日 上午10:54:10
 */
public interface IUserService {
	public IUser findByLoginName(String loginName);
	
	public List<IUser> findByName(String name);
	
}
