package com.loring.pattern;

//双重检查
public class Singleton5 {
    public static volatile Singleton5 singleton;
    private Singleton5(){}
    public static Singleton5 getInstance(){
        if(singleton==null){
            synchronized (Singleton5.class){
                if(singleton==null){
                    singleton=new Singleton5();
                }
            }
        }
        return singleton;
    }
}
