package com.zwq.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/18 19:04
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "run started");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "run completed");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "run started");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "run completed");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "run started");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "run completed");
        });

        thread1.setName("T1");
        thread2.setName("T2");
        thread3.setName("T3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
