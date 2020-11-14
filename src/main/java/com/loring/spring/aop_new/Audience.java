package com.loring.spring.aop_new;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.loring.spring.aop_new.Performance.perform(..))")
    public void performce() { }

    @Before("performce()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performce()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performce()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performce()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    @Around("performce()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}

