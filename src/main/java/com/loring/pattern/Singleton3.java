package com.loring.pattern;

//静态内部类
public class Singleton3 {
    public static class SingletonInstance{
        public static Singleton3 singleton=new Singleton3();
    }
    private Singleton3(){}
    public static Singleton3 getInstance(){
        return SingletonInstance.singleton;
    }
}
