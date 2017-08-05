package com.zwq.demo.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        DemoFirst first = new DemoFirstImpl();
        /*DemoFirst second = new DemoFirst(){
        	@Override
        	public void saveFirst() {
        		System.out.println("调用second");
        	}
        };*/

        //取得代理对象
        DemoFirst firstProxy = (DemoFirst) Proxy.newProxyInstance(first
                .getClass().getClassLoader(), first.getClass().getInterfaces(),
                new InvocationHandlerImpl(first));
        //通过动态代理调用方法
        firstProxy.saveFirst();
        firstProxy.saveSecond();

    }
}