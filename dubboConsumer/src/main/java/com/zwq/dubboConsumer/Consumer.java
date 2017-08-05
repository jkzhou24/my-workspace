package com.zwq.dubboConsumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zwq.dubboAPI.IHello;

public class Consumer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        context.start();
        
        IHello hello = (IHello) context.getBean("helloService");
        System.out.println(hello.sayHello());
	}
}
