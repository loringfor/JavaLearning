package com.interview.leetcode;

public class 完全平方数279 {
    public static int numSquares(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=i/2;j++){
                if(j*j==i){
                    min=0;
                    break;
                }else if(j*j<i){
                    min = Math.min(min,dp[i-j*j]);
                }
            }
            dp[i]=min+1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
