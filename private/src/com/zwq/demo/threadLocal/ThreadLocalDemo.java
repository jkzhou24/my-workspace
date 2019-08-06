package com.zwq.demo.threadLocal;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/21 17:13
 */
public class ThreadLocalDemo {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{

            threadLocal.set("123");
            threadLocal1.set("345");

            System.out.println(threadLocal.get());
        });

        Thread t2 = new Thread(()->{

            threadLocal1.set("345");

            System.out.println(threadLocal1.get());
        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();



    }


}
