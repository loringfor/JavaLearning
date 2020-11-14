package com.loring.spring.aop_new;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance{

    @Override
    public void perform() {
        System.out.println("perform...");
    }
}
