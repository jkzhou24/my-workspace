package com.zwq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zwq.api.IUserService;
import com.zwq.entity.UserModel;

@Controller(value = "test")
@RequestMapping("/mvc")
public class TestController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/hello")
	public @ResponseBody String hello(HttpServletRequest request) {
		// 获取spring级别父容器
		WebApplicationContext rootWac = ContextLoader.getCurrentWebApplicationContext();
		// 获取servletContext
		ServletContext servletContext = rootWac.getServletContext();
		// 获取springmvc级别子容器
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext,
				"org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc");
		// WebApplicationContext wac =
		// RequestContextUtils.getWebApplicationContext(request);

		System.out.println(rootWac == wac);

		UserModel bean = (UserModel) wac.getBean("userModel");
		System.out.println("bean id : " + bean.getId());

		return "hello";
	}

	@RequestMapping("/getUser")
	public @ResponseBody UserModel getUser() {
		return userService.getUser(85);
	}

	@RequestMapping("/saveUser")
	public @ResponseBody UserModel saveUser() {
		UserModel user = new UserModel();
		user.setName("zhoujielun");
		user.setAge(38);
		userService.saveUser(user);
		// 获取自增主键
		System.out.println("userId : " + user.getId());
		return user;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
	}

	@RequestMapping("/testDateBinder")
	public @ResponseBody String testDateBinder(Date date, int num) {
		// http://localhost:8080/private-web/mvc/testDateBinder?date=2017-12-01&num=9
		System.out.println(date.toString());
		System.out.println(num);

		return "test";
	}

	@ModelAttribute
	public void setModelAttribute(Model model) {
		System.out.println("Test Pre-Run");
		model.addAttribute("attr", "abc");
	}

	@RequestMapping("/testModelAttribute")
	public @ResponseBody String testModelAttribute(String attr) {
		System.out.println(attr);
		return "test";
	}

	@RequestMapping("/testValidator")
	public @ResponseBody String testValidator(@Valid UserModel user, Errors errors) {
		// 判断验证是否通过
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (FieldError e : errors.getFieldErrors()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(e.getDefaultMessage());
				break;
			}
			System.out.println(sb.toString());
			return sb.toString();
		}
		System.out.println(user.getName());
		return "test";
	}
}
