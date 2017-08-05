package com.zwq.demo.lang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTheadPool {
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		 
		for (int i=0;i<10;i++) {
			Runnable thread = () -> System.out.println(Thread.currentThread().getName() + "线程被调用了。");
			threadPool.execute(thread);
//			threadPool.submit(thread);
		}
	}
}
