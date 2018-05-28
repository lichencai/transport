package com.zriot.elicense.illegal.security;

import java.util.HashMap;
import java.util.Map;

public class LoginUserInfo {
	/**
     * 过期时间
     */
    private Long expiration;
    /**
     * token
     */
    private String token;
    /**
     * 用户信息 json
     */
    private String json;
    
    public static Map<String, LoginUserInfo> tokenMap = new HashMap<String, LoginUserInfo>();
    
    public static Map<String, LoginUserInfo> userJsonMap = new HashMap<String, LoginUserInfo>();
    
	public Long getExpiration() {
		return expiration;
	}
	public void setExpiration(Long expiration) {
		this.expiration = expiration;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
	
	public static void setTokenInfo(String key, String token, Long expiration) {
		LoginUserInfo info = new LoginUserInfo();
		info.setExpiration(expiration);
		info.setToken(token);
		tokenMap.put(key, info);
	}
	
	public static String getToken(String key) {
		String token = null;
		LoginUserInfo info = tokenMap.get(key);
		if(info != null) {
			token = info.getToken();
		}
		return token;
	}
	
	public static void delToken(String key) {
		tokenMap.remove(key);
	}
	
	
	public static void setUserInfo(String key, String json, Long expiration) {
		LoginUserInfo info = new LoginUserInfo();
		info.setExpiration(expiration);
		info.setJson(json);
		userJsonMap.put(key, info);
	}
	
	public static String getUserJson(String key) {
		String json = null;
		LoginUserInfo info = userJsonMap.get(key);
		if(info != null) {
			json = info.getJson();
		}
		return json;
	}
	
	public static void delUserJson(String key) {
		userJsonMap.remove(key);
	}
}
