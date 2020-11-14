package com.loring.spring.aop_new;


import org.junit.Before;
import org.junit.Test;

public class PerformanceTest {

    private Performance performance;

    @Before
    public void before(){
        this.performance = new PerformanceImpl();
    }

    @Test
    public void perTest(){
        performance.perform();
    }
}