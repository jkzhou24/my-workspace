package com.zwq.demo.jedis;

import com.github.jedis.lock.JedisLock;
import redis.clients.jedis.Jedis;

/*
 * @description:
 * @author: zwq
 * @date: 2019/7/4 18:04
 */
public class JedisLockTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Jedis jedis = new Jedis("192.168.34.92", 6379);
                    lock(jedis, "mmmmmm", num);
                }
            }).start();
        }

    }


    public static void lock(Jedis jedis, String key, int i) {
        JedisLock jedisLock = new JedisLock(jedis, key, 0, 5000000);
        try {
            //获得锁
            if (jedisLock.acquire()) {
                System.out.println(i + "获得锁");
                jedisLock.acquire();
                System.out.println(i + "重入锁");
                Thread.sleep(4000);
                System.out.println(i + "释放锁");
                jedisLock.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
