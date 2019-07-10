package com.loring.base;

public class StringTest {
    public static void main(String[] args) {
        String str="Hello World,My name is Loring!";
        System.out.println(str);
        //String s=str.substring(6);
        String str1=str.replace("is","LOVE");
        String[] s=str1.split(" ");
        for (int i = 0; i <s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println(s);
        System.out.println(">>>>>>>>>>>>>>>>>>");

        String s1="    jksjdkf    jkfjak     kfjsk";
        System.out.println(s1);
        System.out.println(s1.trim());
    }
}
