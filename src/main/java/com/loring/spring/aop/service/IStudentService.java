package com.loring.spring.aop.service;

import com.loring.spring.aop.model.StudentModel;

public interface IStudentService {

    void deleteById(String id, String a);

    int save(StudentModel studentModel);

    void update(StudentModel studentModel);

    void queryById(String id);
}