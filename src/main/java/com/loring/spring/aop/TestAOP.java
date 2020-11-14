package com.loring.spring.aop;

import com.loring.spring.aop.service.StudentServiceImpl;

public class TestAOP {

    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.deleteById("1","A");
    }

}
