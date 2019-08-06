package com.zwq.springBootDemo.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/20 21:15
 */
public class ApiMyElasticJobSimple implements SimpleJob {

    @Override
    public void execute(ShardingContext content) {

        int key = content.getShardingItem();
        System.out.println();
        System.out.println("----------------------"+key+"-------------------");
        System.out.println();

        switch (key) {
            case 0:
                System.out.println("任务调度执行3: "+key);
                break;
            case 1:
                System.out.println("任务调度执行3: "+key);
                break;
            case 2:
                System.out.println("任务调度执行3: "+key);
                break;

            default:
                System.out.println("没有任务调度执行");
                break;
        }
    }
}