package com.zwq.demo.observerPattern;

import java.util.Observable;

public class MySubject extends Observable{
	public void testOb() {
		System.out.println("开始执行");
		setChanged();
		notifyObservers();
	}
	
	public static void main(String[] args) {
		MySubject subject = new MySubject();
		subject.addObserver(new MyObserver());
		subject.addObserver(new MyObserver());
		subject.addObserver(new MyObserver());
		subject.addObserver(new MyObserver());
		subject.testOb();
	}
}
