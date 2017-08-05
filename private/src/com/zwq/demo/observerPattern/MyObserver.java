package com.zwq.demo.observerPattern;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者更新操作");
	}

}
