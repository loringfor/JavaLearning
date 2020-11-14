package com.loring.spring.introduce_enhancement;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

@Component
public class Manager extends DelegatingIntroductionInterceptor implements Management {
    @Override
    public void manage(String name) {
        System.out.println(name + "，您好，我是经理，负责管理服务员");
    }
}
