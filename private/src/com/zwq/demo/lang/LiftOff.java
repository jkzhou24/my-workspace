package com.zwq.demo.lang;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
	}

	@Override
	public void run() {
		while(countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new LiftOff());
		Thread t1 = new Thread(new LiftOff());
		Thread t2 = new Thread(new LiftOff());
		t.start();
		Thread.yield();
		t1.start();
//		t1.join();
		t2.start();
//		t.run();
//		t1.run();
//		t2.run();
	}

}
