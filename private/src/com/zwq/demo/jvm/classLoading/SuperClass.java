package com.zwq.demo.jvm.classLoading;

public class SuperClass {
	static {
		System.out.println("super class init");
	}
	
	public SuperClass(){
		System.out.println("constructor");
	}
	
	
	public static int i = 1;
}
