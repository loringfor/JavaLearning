package com.loring.spring.myIOC;

import java.io.FileNotFoundException;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws FileNotFoundException,Exception;
}
