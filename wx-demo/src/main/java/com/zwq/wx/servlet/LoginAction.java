package com.zwq.wx.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwq.wx.util.AuthUtil;

@WebServlet("/wxLogin")
public class LoginAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myPublicDomain = "http://www.zhouwenqing.in.3322.org:32255";//这里填写自己的内网映射域名，可以使用花生壳或者使用ngrok，后者比较简单
		String backUrl = myPublicDomain + "/wx-demo/callBack";
		
		/*
		 * 在确保微信公众账号拥有授权作用域（scope参数）的权限的前提下（服务号获得高级接口后，默认拥有scope参数中的snsapi_base和snsapi_userinfo）
		 * ，引导关注者打开如下页面： 
		 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
		 * 
		 * 尤其注意：
		 * 由于授权操作安全等级较高，所以在发起授权请求时，微信会对授权链接做正则强匹配校验，
		 * 如果链接的参数顺序不对，授权页面将无法正常访问
		 * 跳转回调redirect_uri，应当使用https链接来确保授权code的安全性
		 */
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		System.out.println("this is LoginServlet!-->"+url);
		resp.sendRedirect(url);
	}

}
