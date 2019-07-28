package com.interview.huawei;

import java.util.Scanner;

public class 汽水瓶 {

    static int res=0;
    public static int dfs(int n){
        if(n==0 || n==1)
            return 0;
        if(n==2){
            res++;
            return res;
        }
        int temp = n/3;
        res+=temp;
        dfs(temp+n%3);
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            if(n==0)
                break;
            System.out.println(n/2);
        }
    }

}
