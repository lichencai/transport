package com.zriot.elicense.illegal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zriot.elicense.illegal.response.Response;
import com.zriot.elicense.illegal.security.TokenUtil;
import com.zriot.elicense.illegal.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户操作
 */
@Slf4j
@RestController
@RequestMapping(value="/iuser")
public class IUserController {
	
	@Autowired
	IUserService iUserService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private TokenUtil jwtTokenUtil;
	
	/**
	 * 数据后台登录
	 */
	@PostMapping("/login")
	public Response<Object> login(HttpServletRequest request, HttpServletResponse response) {
		try {
			final Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(request.getParameter("loginName"), request.getParameter("password"))
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        final String token = jwtTokenUtil.generateToken(userDetails);
	        
	        Map<String, Object> tokenMap = new HashMap<>();
	        tokenMap.put("access_token", token);
	        tokenMap.put("expires_in", jwtTokenUtil.getExpiration());
	        tokenMap.put("token_type", TokenUtil.TOKEN_TYPE_BEARER);
			return Response.successResponse(tokenMap);
		} catch (Exception e) {
			log.error("登录失败", e);
			return Response.failResponse("登录失败");
		}
	}
	
	@PostMapping("/userInfo")
	public Response<String> getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		return Response.successResponse(userDetails.getUsername());
	}
	
	
	
	
}
