package com.zwq.demo.lang;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i=0;i<10;i++) {
			map.put(i, "value");
		}
		System.out.println(map);
		
//		for(Map.Entry entry : map.entrySet()) {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//		}
		
//		for(Integer i : map.keySet()){
//			System.out.println(i);
//		}
		
		for(String value : map.values()){
			System.out.println(value);
		}
		
	}
}
