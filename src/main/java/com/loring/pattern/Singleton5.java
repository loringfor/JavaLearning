package com.loring.pattern;

//双重检查
public class Singleton5 {
    public static volatile Singleton5 singleton;
    private Singleton5(){}
    public static Singleton5 getInstance(){
        if(singleton==null){
            synchronized (Singleton5.class){
                if(singleton==null){
//                    a.获取对象地址；
//                    b.在对象地址上初始化一个Factory对象；
//                    c.将factory引用指向对象地址；
                    singleton=new Singleton5();
                }
            }
        }
        return singleton;
    }
}
