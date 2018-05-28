package com.zriot.elicense.illegal.security.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.zriot.elicense.illegal.model.IUser;

/**
 * The type Auth user factory.
 */
public final class AuthUserFactory {

    private AuthUserFactory() {
    }

    /**
     * Create auth user.
     *
     * @param user the user
     * @return the auth user
     */
    public static AuthUser create(IUser user) {
        AuthUser authUser = new AuthUser(user.getId());
        authUser.setLoginName(user.getLoginName());
        authUser.setName(user.getName());
        authUser.setEmail(user.getEmail());
        authUser.setPhone(user.getPhone());
        authUser.setMobile(user.getMobile());
        authUser.setPassword(user.getPassword());
        authUser.setEnabled(true);
        authUser.setAuthorities(mapToGrantedAuthorities());
        return authUser;
    }

    /**
     * 权限转换
     *
     * @param sysRoles 角色列表
     * @param sysMenus 菜单列表
     * @return 权限列表
     */
    private static List<SimpleGrantedAuthority> mapToGrantedAuthorities() {

        /*List<SimpleGrantedAuthority> authorities =
            sysRoles.stream().filter(SysRole::getEnabled)
                .map(sysRole -> new SimpleGrantedAuthority(sysRole.getName())).collect(Collectors.toList());

        // 添加基于Permission的权限信息
        sysMenus.stream().filter(menu -> StringHelper.isNotBlank(menu.getPermission())).forEach(menu -> {
            // 添加基于Permission的权限信息
            for (String permission : StringHelper.split(menu.getPermission(), ",")) {
                authorities.add(new SimpleGrantedAuthority(permission));
            }
        });*/
    	
    	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        return authorities;
    }

}
