package com.penghai.elebusiness.dao;

import java.util.List;

import com.penghai.elebusiness.bo.UserRegistration;

public interface UserRegistrationMapper {
	/*
	 * 根据用户username查找数据库是否存在相同用户名
	 * @author tuzki
	 */
	public List<UserRegistration> findUserByUsername(String username);
	
	
	
	/*
	 * 向数据库增加一条用户注册信息
	 */
	
	public void insert(String username,String pwd,String email,String phone);
	

	

}
