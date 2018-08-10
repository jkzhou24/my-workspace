package com.zwq.demo.webservice.server;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		String address = "http://localhost:8082/webservice/sayHello";
		Endpoint.publish(address, new SayHelloImpl());
		System.out.println("发布sayHello成功");
	}
}
