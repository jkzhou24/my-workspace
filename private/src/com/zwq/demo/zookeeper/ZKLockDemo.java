package com.zwq.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;

import java.util.concurrent.TimeUnit;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/10 12:07
 */
public class ZKLockDemo {

    /**
     * Zookeeper info
     */
    private static final String ZK_ADDRESS = "192.168.34.108:2181";
    private static final String ZK_LOCK_PATH = "/tolock1";

    public static void main(String[] args) throws Exception {
        // 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();
        System.out.println("zk client start successfully!");

        Thread t1 = new Thread(() -> {
            doWithLock(client);
        }, "t1");
        Thread t2 = new Thread(() -> {
            doWithLock(client);
        }, "t2");

        t1.start();
        t2.start();

        //client.create().forPath("/yyy");
        //
        //doWithLock(client);

    }

    private static void doWithLock(CuratorFramework client) {
        InterProcessMutex lock = new InterProcessMutex(client, ZK_LOCK_PATH);
        try {
            if (lock.acquire(0, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " hold lock");
                Thread.sleep(3000L);
            } else {
                System.out.println(Thread.currentThread().getName() + " give up lock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println(Thread.currentThread().getName() + " release lock");
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
