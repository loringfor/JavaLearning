package com.loring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHander(userService);

        for (int i = 0; i < 10; i++) {
            UserService userServiceProxy =(UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                    userService.getClass().getInterfaces(), invocationHandler);
            System.out.println(userServiceProxy.getName(i));
            System.out.println(userServiceProxy.getAge(1));
            System.out.println("================================");
        }
    }
}
