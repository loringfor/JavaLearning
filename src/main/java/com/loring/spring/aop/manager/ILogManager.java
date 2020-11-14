package com.loring.spring.aop.manager;

import com.loring.spring.aop.manager.model.LogAdmModel;

public interface ILogManager {
    /**
     * 日志处理模块
     * @param paramLogAdmBean
     */
    void dealLog(LogAdmModel paramLogAdmBean);
}