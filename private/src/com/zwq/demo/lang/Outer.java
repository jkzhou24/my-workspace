package com.zwq.demo.lang;

public class Outer {
	 //外部类私有数据域   
    private int data=0;   
    private int data2=1;   
    //内部类   
    class Inner{   
        void print(){   
              //内部类访问外部私有数据域   
              System.out.println(data);   
              System.out.println(data2);   
        }    
    }   
}
