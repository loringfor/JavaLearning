package com.loring.spring.aop.manager.impl;

import com.google.gson.Gson;
import com.loring.spring.aop.manager.ILogManager;
import com.loring.spring.aop.manager.model.LogAdmModel;
import org.springframework.stereotype.Service;

@Service
public class DBLogManager implements ILogManager {
    @Override
    public void dealLog(LogAdmModel paramLogAdmBean) {
        Gson gson = new Gson();
        System.out.println("将日志存入数据库,日志内容如下: " + gson.toJson(paramLogAdmBean));
    }
}
