package com.penghai.elebusiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penghai.elebusiness.bo.UserRegistration;
import com.penghai.elebusiness.dao.UserRegistrationMapper;

/*
 * 新用户注册信息的service
 * @author tuzki
 */
@Service
public class UserRegistrationService {
	@Autowired
	private UserRegistrationMapper userRegistrationMapper;
	
	//检测数据库中是否有相同用户名
	public List<UserRegistration> findSameUsername(String username) {
		List<UserRegistration> userinfo = userRegistrationMapper.findUserByUsername(username);
			return userinfo;
	}
	
	//注册账号
	public void insertUser(String username,String pwd,String email,String phone) {
		userRegistrationMapper.insert(username, pwd, email, phone);
	
		
	}
	

	
	
}
