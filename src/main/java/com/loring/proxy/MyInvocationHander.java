package com.loring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHander implements InvocationHandler {
    private Object target;
    public MyInvocationHander(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("getName".equals(method.getName())){
            System.out.println("---before "+method.getName()+"----");
            Object result = method.invoke(target,args);
            System.out.println("---after "+method.getName()+"----");
            return result;
        }
        else {
            Object result = method.invoke(target, args);
            return result;
        }
    }


}
