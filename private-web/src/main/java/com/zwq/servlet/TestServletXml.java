package com.zwq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletXml extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public TestServletXml() {
		System.out.println("testServletXml constructor");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("初始化servlet参数flag:" + this.getInitParameter("flag"));
		System.out.println("初始化web参数flag:" + this.getServletContext().getInitParameter("contextConfigLocation"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("this is servlet by xml config");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
