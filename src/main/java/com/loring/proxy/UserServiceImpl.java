package com.loring.proxy;

public class UserServiceImpl implements UserService {
    public String getName(int id) {
        System.out.println("---getName---");
        return "Loring"+ id;
    }

    public Integer getAge(int id) {
        System.out.println("---getAge---");
        return 100;
    }
}
