package com.zwq.demo.concurrent;

public class LockThread extends Thread {
	private LockDomain ld;
	public LockThread (LockDomain ld) {
		this.ld = ld;
	}
	
	@Override
	public void run() {
		ld.await();
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockDomain ld = new LockDomain();
		LockThread lt1 = new LockThread(ld);
		LockThread lt2 = new LockThread(ld);
		lt1.start();
		lt2.start();
		Thread.sleep(1000);
		ld.signal();
		
	}
}
