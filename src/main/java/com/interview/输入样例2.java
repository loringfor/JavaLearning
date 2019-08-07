package com.interview;

import java.io.*;

public class 输入样例2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=in.readLine())!=null){
            System.out.println(str);
        }
    }
}
