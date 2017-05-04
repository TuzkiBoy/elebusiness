package com.penghai.elebusiness.controller;

import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

/*
 * Controller基类
 * @author tuzki
 */
public class BaseController {
	public HttpServletRequest request;
	public HttpServletResponse response;
	// 启用日志
	Logger log = Logger.getLogger(BaseController.class);
	public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式--年月日时分秒
	public SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH");// 设置日期格式--年月日时
	public SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式--年月日

	@ModelAttribute
	public void initial(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		this.request = request;
		this.response = response;
	}

}
