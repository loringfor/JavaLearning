package com.loring.spring.introduce_enhancement;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;

public class SpringIntroductionInterceptorDemo {
    public static void main(String[] args) {
        System.out.println("Spring引介增强测试");
        System.out.println("==========我是分割线==========");
        ProxyFactory factory = new ProxyFactory(new Waiter());
        factory.setProxyTargetClass(true); // 强制私用CGLIB,以保证我们的Waiter方法也能正常调用
        Advice advice = new DelegatePerTargetObjectIntroductionInterceptor(Manager.class, Management.class);
        factory.addAdvice(advice);
        Waiter waiter = (Waiter)factory.getProxy();
        waiter.serve("xyl");
        // waiter.driving("loring");
        System.out.println("==========我是分割线==========");
        Management management = (Management)waiter;
        management.manage("loring");
    }
}
