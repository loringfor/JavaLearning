package com.interview.huawei;

import java.util.Scanner;

public class 进制转换 {
    public static int change(String str){
        int count=0;
        int j=0;
        for(int i=str.length()-1;i>1;i--){
            count+= getNum(str.charAt(i)) * Math.pow(16,j);
            j++;
        }
        return count;
    }
    public static int getNum(char c){
        if(c>'A'&&c<'F')
            return c-'A'+10;
        else if(c>'0'&&c<'9')
            return c-'0';
        return -1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            System.out.println(change(str));
        }
    }
}
