package com.zwq.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/18 19:39
 */
public class SemaphoreDemo {


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    resolve(count);
                    semaphore.release();
                } catch (Exception e) {
                }
            });
        }
        executorService.shutdown();
    }

    private static void resolve(int i) throws InterruptedException {
        System.out.println("服务号 " +  i + " 受理中");
        Thread.sleep(2000);
    }
}
