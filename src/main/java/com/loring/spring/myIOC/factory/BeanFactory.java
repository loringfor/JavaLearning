package com.loring.spring.myIOC.factory;

public interface BeanFactory {
    Object getBean(String beanId) throws Exception;
}
