package com.zwq.demo.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDomain {
	private Lock lock = new ReentrantLock();
	private Condition con1 = lock.newCondition();
	private Condition con2 = lock.newCondition();
	
	public void await() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "获取同步锁成功");
			con1.await();
			System.out.println(Thread.currentThread().getName() + "执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signal() {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "获取同步锁成功");
		con1.signalAll();
		lock.unlock();
	}
	
}
