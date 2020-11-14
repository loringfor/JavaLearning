package com.loring.exception;

public class Test {
    public static void main(String[] args) {
        System.out.println(add(2,0));
    }

    public static int add(int a,int b){
        try {
            return a/b;
        }catch (Exception e){
            System.out.println(e);
            return a + b;
        }finally {
            System.out.println("finally");
            return a * b;
        }
    }
}
