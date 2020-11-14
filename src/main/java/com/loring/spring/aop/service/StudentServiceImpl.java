package com.loring.spring.aop.service;

import com.google.gson.Gson;
import com.loring.spring.aop.model.StudentModel;
import org.springframework.stereotype.Service;

@Service
// 启动日志拦截
public class StudentServiceImpl implements IStudentService {
    private static Gson gson = new Gson();
    @Override
    // 添加日志标识
    public void deleteById(String id, String a) {
        System.out.printf(this.getClass() +  "deleteById  id = " + id);
    }

    @Override
    // 添加日志标识
    public int save(StudentModel studentModel) {
        System.out.printf(this.getClass() +  "save  save = " + gson.toJson(studentModel));
        return 1;
    }

    @Override
    // 添加日志标识
    public void update(StudentModel studentModel) {
        System.out.printf(this.getClass() +  "save  update = " + gson.toJson(studentModel));
    }

    // 没有日志标识
    @Override
    public void queryById(String id) {
        System.out.printf(this.getClass() +  "queryById  id = " + id);
    }
}
