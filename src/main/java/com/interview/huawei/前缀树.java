package com.interview.huawei;

import java.util.Scanner;

public class 前缀树 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] labels = new int[len];
            int[] hasChild = new int[len];
            int[] pouds = new int[len];
            for(int i=0;i<len;i++){
                labels[i]=in.nextInt();
            }
            for(int i=0;i<len;i++){
                hasChild[i]=in.nextInt();
            }
            for(int i=0;i<len;i++){
                pouds[i]=in.nextInt();
            }
            int N = in.nextInt();
            int[] values = new int[N];
            for(int i=0;i<N;i++){
                values[i]=in.nextInt();
            }
            int P = in.nextInt();
            int[] key = new int[N];
            for(int i=0;i<P;i++){
                key[i]=in.nextInt();
            }



        }
    }
}
