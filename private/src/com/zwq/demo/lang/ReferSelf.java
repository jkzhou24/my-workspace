package com.zwq.demo.lang;

public class ReferSelf {
	
	private ReferSelf a;
	
//	public ReferSelf(){
//		a = new ReferSelf();
//	}
	
	public static void main(String[] args) {
		ReferSelf a = new ReferSelf();
	}

}
