package com.zwq.demo.dynamicProxy;

/**
 * DemoFirstImpl实现DemoFirst接口，覆写saveFirst()方法
 * 真实主题，负责执行具体业务 
 */
public class DemoFirstImpl implements DemoFirst {

    @Override
    public void saveFirst() {
        System.out.println("调用saveFirst()方法");
    }

	@Override
	public void saveSecond() {
		System.out.println("调用saveSecond()方法");
	}

}