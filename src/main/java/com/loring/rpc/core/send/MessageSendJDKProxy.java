package com.loring.rpc.core.send;

import com.loring.rpc.core.MessageCallBack;
import com.loring.rpc.core.RpcServerLoader;
import com.loring.rpc.model.MessageRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

public class MessageSendJDKProxy<T> implements InvocationHandler {

    public <T> T bindProxy(Class<T> rpcInterface){
        return (T) Proxy.newProxyInstance(
                rpcInterface.getClassLoader(), new Class<?>[]{rpcInterface}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
