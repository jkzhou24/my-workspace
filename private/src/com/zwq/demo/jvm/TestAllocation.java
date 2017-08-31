package com.zwq.demo.jvm;

public class TestAllocation {

	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];// 书上jdk1.6出现一次Minor GC，自己测试时1.8直接分配到老年代
		
		/*
		 Heap
		 PSYoungGen      total 9216K, used 7292K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
		  eden space 8192K, 89% used [0x00000000ff600000,0x00000000ffd1f148,0x00000000ffe00000)
		  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
		  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
		 ParOldGen       total 10240K, used 0K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
		  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
		 Metaspace       used 2661K, capacity 4486K, committed 4864K, reserved 1056768K
		  class space    used 286K, capacity 386K, committed 512K, reserved 1048576K
		*/

	}
	
	public static void main(String[] args) {
		TestAllocation.testAllocation();
	}

}
