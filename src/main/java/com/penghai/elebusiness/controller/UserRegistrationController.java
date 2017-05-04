package com.penghai.elebusiness.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.penghai.elebusiness.bo.UserRegistration;
import com.penghai.elebusiness.service.UserRegistrationService;

@Controller
@Path(value="/user")
@Produces("application/json") 
public class UserRegistrationController extends BaseController{
	@Autowired 
	private UserRegistrationService userRegistrationService;
	//写注册信息前判断数据库中是否存在相同的用户名
	@GET
	@Path(value="/login")
	public boolean sameUser(String username) {
		System.out.println("%%%%%%%%%%%1111");
		List<UserRegistration> users = userRegistrationService.findSameUsername(username);
		//如果前端传入的用户名和后端提交到controller层的用户名相同，则返回false
		
		JSONArray jsonArray = new JSONArray();
		for(UserRegistration user :users){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("username", user.getUsername());
			jsonArray.add(jsonObject);
		}
		//从数据库提取出json串
		System.out.println(jsonArray);
		//将前端传入的json数据与jsonArray对比，相同返回false
		if(param==jsonArray){
			return false;
		} else {
			return true;
		}

	}


	//用户名不存在则加入数据库中,执行service层中的addNewUserInfo方法,将用户信息加入数据库中 ,返回注册成功和注册失败信息      
	//ajax请求
	@POST
	@Path(value="/registration")
	//从前端页面获取到注册信息，账号、密码、email、电话，添加到数据库中
	public boolean addUser(@RequestBody String username,String pwd,String email,String phone){
		//将前端页面传入的数据转换成List
		String str=param;

		
		
		
		return false;

	
}

	

