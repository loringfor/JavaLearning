package com.interview.pdd;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int K = in.nextInt();
            count =0;
            res="";
            core("",N,M,K,0,0);
            System.out.println(res);
        }
    }

    static int count = 0;
    static String res="";

    public static void core(String cur,int n,int m,int k,int n1,int m1){
        if(count==k){
            res = cur;
            return;
        }
        if(n1<n){
            count++;
            core(cur+"a",n,m,k,n1+1,m1);
        }
        if(m1<m){
            count++;
            core(cur+"b",n,m,k,n1,m1+1);
        }
    }

}


//    public static int countC(int n,int m){
//        if(n==0 || m==0){
//            return 1;
//        }
//        int t=1,count=n;
//
//        while (count>0){
//            t *= count+m;
//            --count;
//        }
//        int temp =1;
//        while(n!=0){
//            temp *=n;
//            --n;
//        }
//        return t/temp;
//    }
