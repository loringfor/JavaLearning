package com.loring.proxy.cglib;

public class TestCglibProxy {
    public static void main(String[] args) {
        CglibProxy proxy=new CglibProxy();
        HelloWorld helloWorld=(HelloWorld)proxy.getProxy(HelloWorld.class);
        helloWorld.sayHello();
    }
}
