package com.zwq.demo.codePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionRemove {

    public static void main(String[] args){
        ArrayList<String> arrList = new ArrayList<String>();
        String[] arr = {"一丰","广丰","宝马","奥迪","保时捷","沃尔沃","悍马","路虎","凯迪拉克"};
        arrList.addAll(Arrays.asList(arr));     //将数组转成集合

        //删除前：
        for (String thisItem:arrList){
            System.out.println("---"+thisItem);
        }
        System.out.println("#########################");

        //使用迭代器删除集合中的元素
        Iterator it = arrList.iterator();
        while(it.hasNext()){    //it.hasNext()判断是否还有下一个元素
            if("悍马".equals(it.next())){     //it.next()代表下一个元素
                it.remove();        //【记得：remove()方法一定要调用迭代器的，不能调用List集合的】
            }
        }

        //删除后：
        for (String thisItem:arrList){
            System.out.println("---"+thisItem);
        }

    }
}