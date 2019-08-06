package com.zwq.demo.jedis;

import redis.clients.jedis.Jedis;

/*
 * @description:
 * @author: zwq
 * @date: 2019/7/9 18:19
 */
public class JedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.34.92", 6379);
        jedis.flushDB();

        jedis.set("key123", "1");
        jedis.incrBy("key123", 24);
        jedis.incr("key123");
        System.out.println(jedis.get("key123"));

        jedis.zadd("zsetkey", 2, "B");
        jedis.zadd("zsetkey", 5, "E");
        jedis.zadd("zsetkey", 1, "A");
        jedis.zadd("zsetkey", 4, "D");
        jedis.zadd("zsetkey", 3, "C");
        System.out.println(jedis.zrange("zsetkey", 0, 3));

        //String
        jedis.set("key20190709", "dododo");
        jedis.append("key20190709", "123");
        System.out.println(jedis.get("key20190709"));
        System.out.println(jedis.dbSize());
        jedis.setex("key3", 2, "value3");


        //list
        jedis.lpush("collections", "111");
        jedis.lpush("collections", "222");
        jedis.lpush("collections", "333");
        System.out.println("collections的内容："+jedis.lrange("collections", 0, -1));
    }

}
