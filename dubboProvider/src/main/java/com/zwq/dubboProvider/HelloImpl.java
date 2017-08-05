package com.zwq.dubboProvider;

import com.zwq.dubboAPI.IHello;

public class HelloImpl implements IHello{

	@Override
	public String sayHello() {
		return "hello comsumer, this is reponse from provider";
	}

}
