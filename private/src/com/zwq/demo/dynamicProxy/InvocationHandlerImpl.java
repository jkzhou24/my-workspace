package com.zwq.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandlerImple实现InvocationHandler接口，覆写invoke()方法
 * 代理主题的业务写在invoke()方法中
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;
    
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("target : " + target.getClass().getName());
        System.out.println("proxy : " + proxy.getClass().getName());
        System.out.println("method : " + method.getName());
        System.out.println("args ： " + args);
        System.out.println("开始记录日志");
//        Object obj = method.invoke(target, args);
        System.out.println("结束记录日志");
        /*    
         * System.out.println("obj : " + obj.getClass().getName());
         * 本例中saveXXX方法没有返回值所以obj会报空指针异常
         */
        return null;
    }
}