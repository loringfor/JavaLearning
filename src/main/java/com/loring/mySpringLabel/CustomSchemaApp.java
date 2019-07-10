package com.loring.mySpringLabel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomSchemaApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Apple apple = applicationContext.getBean(Apple.class);
        System.out.println(apple.getPrice() + ", " + apple.getOrigin());
    }
}
