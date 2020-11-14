package com.loring.proxy.jdkProxy;

public class ProxyTest {
    public static void main(String[] args) {
        testJdkProxy();
    }

    public static void testJdkProxy(){
        JdkProxyExample jdk=new JdkProxyExample();
        HelloWorld proxy=(HelloWorld) jdk.getProxy(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}
