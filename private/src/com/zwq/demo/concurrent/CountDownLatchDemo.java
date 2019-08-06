package com.zwq.demo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/18 18:43
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " started");
                countDownLatch.await(5, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + " completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " completed");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " completed");
        });

        thread1.setName("T1");
        thread2.setName("T2");
        thread3.setName("T3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
