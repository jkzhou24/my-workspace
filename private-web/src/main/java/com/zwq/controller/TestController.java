package com.zwq.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zwq.api.IUserService;
import com.zwq.entity.UserModel;

@Controller(value="test")
@RequestMapping("/mvc")
public class TestController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/hello")
    public @ResponseBody String hello(HttpServletRequest request){        
		//获取spring级别父容器
		WebApplicationContext rootWac = ContextLoader.getCurrentWebApplicationContext();
		//获取servletContext
		ServletContext servletContext = rootWac.getServletContext(); 
		//获取springmvc级别子容器
		WebApplicationContext wac=WebApplicationContextUtils.
			getWebApplicationContext(servletContext,
				"org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc" );
//		WebApplicationContext wac = RequestContextUtils.getWebApplicationContext(request);
		
		System.out.println(rootWac == wac);
		
		UserModel bean = (UserModel)wac.getBean("userModel");
		System.out.println("bean id : " + bean.getId());
		
        return "hello";
    }
	
	@RequestMapping("/getUser")
	public @ResponseBody UserModel getUser() {
		return userService.getUser(1);
	}
	
	@RequestMapping("/saveUser")
	public @ResponseBody UserModel saveUser() {
		UserModel user = new UserModel();
		user.setName("zhoujielun");
		user.setAge(38);
		userService.saveUser(user);
		//获取自增主键
		System.out.println(user.getId());
		return user;
	}
	
	@RequestMapping("/getTestPage")
	public String getTestPage() {
		return "test";
	}
}
