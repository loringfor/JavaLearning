package com.loring.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContextAop.xml");
        Dog dog =(Dog) ac.getBean("dog");
        System.out.println(dog.getClass());
        dog.say();
    }
}
