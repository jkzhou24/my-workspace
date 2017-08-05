package com.zwq.demo.lang;

public class intern {
	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "b";
		String str3 = "ab";
		String str4 = str1 + str2;
		String str5 = new String("ab");
		String str6 = "a" + "b";
		 
		System.out.println(str5.equals(str3));
		System.out.println(str5 == str3);
		System.out.println(str3 == str4);
		System.out.println(str3 == str6);
		System.out.println(str5.intern() == str3);
		System.out.println(str5.intern() == str4);
	}
}
