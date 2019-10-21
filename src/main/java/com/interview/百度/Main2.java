package com.interview.百度;

import java.util.Scanner;

public class Main2 {

    static int res=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            res=0;
            dfs(n,k);
            System.out.println(res);
        }
    }

    public static void dfs(int n,int k){
        if((n+k)%2==0 && (n-k)/2>0){
          int temp = n+k >>1;
          dfs(temp,k);
          dfs(temp-k,k);
        }else{
            res++;
            return;
        }
    }
}
