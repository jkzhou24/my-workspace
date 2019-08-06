package com.zwq.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryNTimes;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/10 11:11
 */
public class ZKWatchDemo {
    public static void main(String[] args) throws Exception {
        //connect
        final String ZOOKEEPER_ADDRESS = "192.168.34.108:2181";
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZOOKEEPER_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();

        // 2.Register watcher
        PathChildrenCache watcher = new PathChildrenCache(
                client,
                "/lock",
                true    // if cache data
        );
        watcher.getListenable().addListener((client1, event) -> {
            ChildData data = event.getData();
            if (data == null) {
                System.out.println("No data in event[" + event + "]");
            } else {
                System.out.println("Receive event: "
                        + "type=[" + event.getType() + "]"
                        + ", path=[" + data.getPath() + "]"
                        + ", data=[" + new String(data.getData()) + "]"
                        + ", stat=[" + data.getStat() + "]");
            }
        });
        watcher.start();
        System.out.println("Register zk watcher successfully!");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
