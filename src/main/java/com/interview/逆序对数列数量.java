package com.interview;

import java.util.Scanner;

public class 逆序对数列数量 {
//    对于一个数列{ai}，如果有i<j且ai>aj，那么我们称ai与aj为一对逆序对数。若对于任意一个由1~n自然数组成的
//    数列，可以很容易求出有多少个逆序对数。那么逆序对数为k的这样自然数数列到底有多少个？
//    输入：数组长度n，逆序对数量m
//    dp[i][j]=dp[i-1][j]+dp[i-1][j-1]+......+dp[i-1][0];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] dp = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                dp[i][0]=1;
                for(int j=1;j<=m && j<i*(i-1)/2;j++){
                    for(int k=1;k<=j;k++){
                        dp[i][j] +=dp[i-1][k];
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
