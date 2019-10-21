package com.interview.拼多多;

import java.util.*;

public class 字符串中数值最大的子串 {
//    123.456.789
//    123.456.123
//    123abc789.4mk56.1cde23
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            double res=0.0;
            for(int i=0; i<str.length()-1;i++) {
                for(int j=i+1;j<str.length()+1;j++) {
                    String temp=str.substring(i, j);
                    try {
                        res=Math.max(res, Double.valueOf(temp));
                    }catch(NumberFormatException e) {
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }

}
