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
import org.springframework.web.bind.annotation.RequestParam;
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
		List<UserRegistration> users = userRegistrationService.findSameUsername(username);
		
		//如果前端传入的用户名和后端提交到controller层的用户名相同，则返回false
		JSONArray jsonArray = new JSONArray();
		for(UserRegistration user :users){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("username", user.getUsername());
			jsonArray.add(jsonObject);
		}
		//从数据库提取出json串
		System.out.println(jsonArray);  //提取出json串
		//将前端传入的json数据与jsonArray中的值对比，相同返回false
		if(request.getParameter("username")==jsonArray.){
			return false;
		} else {
			return true;
		}

	}


	//用户名不存在则加入数据库中,将用户信息加入数据库中 ,返回注册成功和注册失败信息      
	@POST
	@Path(value="/registration")
	@ResponseBody
	//从前端页面获取到注册信息，账号、密码、email、电话，添加到数据库中
	public boolean addUser(@RequestParam("username") String username,
						@RequestParam("pwd") String pwd,
						@RequestParam("email") String email,
						@RequestParam("phone") String phone){
		String userInfo = userRegistrationService.insertUser(username, pwd, email, phone);
		
		
		
		
		return false;
	}
}
	

