package com.zriot.elicense.illegal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zriot.elicense.illegal.model.IUser;
import com.zriot.elicense.illegal.security.model.AuthUserFactory;
import com.zriot.elicense.illegal.service.IUserService;

/**
 * Security User Detail Service
 *
 * @author zhangxd
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * 系统服务
     */
	@Autowired
	IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
        IUser user = iUserService.findByLoginName(loginName);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
