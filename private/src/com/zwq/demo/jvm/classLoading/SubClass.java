package com.zwq.demo.jvm.classLoading;

public class SubClass extends SuperClass{
	
	static {
		System.out.println("sub class init");
	}
	
}
