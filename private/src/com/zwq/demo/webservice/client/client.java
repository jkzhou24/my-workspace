package com.zwq.demo.webservice.client;

public class client {
    public static void main(String[] args) {
        SayHelloImpl222Service sayHelloImpl222Service = new SayHelloImpl222Service();
        SayHelloImpl sayHello = sayHelloImpl222Service.getSayHelloImplPort();
        System.out.println(sayHello.sayHello("nana"));
    }
}
