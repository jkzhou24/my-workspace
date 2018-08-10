package com.zwq.demo.webservice.server;

import javax.jws.WebService;

@WebService
public class SayHelloImpl implements ISayHello {

	@Override
	public String sayHello(String name) {
		System.out.println("收到来自" + name + "的消息");
		return "hello:" + name;
	}

}
