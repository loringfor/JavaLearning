package com.loring.rpc.core.send;

import com.loring.rpc.core.MessageCallBack;
import com.loring.rpc.core.RpcServerLoader;
import com.loring.rpc.model.MessageRequest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.UUID;

public class MessageSendCGlibProxy implements MethodInterceptor {

    /**
     * 生成 CGLIB 代理对象
     * @param cls 一一 Class 类
     * @return Class 类的 CGLIB 代理对象
    */
    public Object getProxy(Class cls) {
        //CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现 Methodinterceptor 方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }
    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method 方法
     * @param args 方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
    */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        MessageRequest request = new MessageRequest();
        request.setMessageId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setTypeParameters(method.getParameterTypes());
        request.setParametersVal(args);

        MessageSendHandler messageSendHandler = RpcServerLoader.getInstance().getMessageSendHandler();
        MessageCallBack callBack = messageSendHandler.sendRequest(request);
        System.out.println("调用了："+ method.toString());
        return callBack.start();
    }
}
