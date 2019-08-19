package com.interview.剑指offer;

public class 不用加减乘除做加法 {
    public static int add(int num1,int num2) {
        while(num2!=0){
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        int a=71;
        int b=71;
        System.out.println(add(a,b));
        System.out.println(a^b);
    }
}
