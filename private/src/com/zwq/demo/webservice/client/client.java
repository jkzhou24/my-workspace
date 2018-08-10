package com.zwq.demo.webservice.client;

public class client {
    public static void main(String[] args) {
        SayHelloImplService sayHelloImplService = new SayHelloImplService();
        SayHelloImpl sayHello = sayHelloImplService.getSayHelloImplPort();
        System.out.println(sayHello.sayHello("nana"));
    }
}
