package com.interview.bytedance;

import java.util.Scanner;

public class Main3 {
    public static int getScores(int[] nums){
        int len = nums.length;
        int res = 0;
        if(len%2 == 0){
            int res1 = 0,res2 = 0;
            for(int i = 0;i<len;i++){
                if(i%2==1) {
                    res1+=nums[i];
                } else {
                    res2+=nums[i];
                }
            }
            res = Math.max(res1,res2);
        }else{
            int res1 = 0,res2 = 0;
            for(int i = 0;i<len-1;i++){
                if(i%2==0) {
                    res1+=nums[i];
                } else {
                    res2+=nums[i];
                }
            }
            res = Math.min(res1,res2)+nums[len-1];

            res1 = 0;
            res2 = 0;
            for(int i = 1;i<len;i++){
                if(i%2==0) {
                    res1+=nums[i];
                } else {
                    res2+=nums[i];
                }
            }
            res = Math.max(res,Math.min(res1,res2)+nums[0]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i = 0; i < len; i++){
                nums[i] = in.nextInt();
            }
            System.out.println(getScores(nums));
        }
    }

    public int PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int sum=0;
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum+=nums[i];
        }
        //DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1]+sum >>1;
    }

}
//public class Main3 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int N = in.nextInt();
//            int[] nums = new int[N];
//            for(int i=0;i<N;i++){
//                nums[i] = in.nextInt();
//            }
//
//            int[][] dp = new int[N+1][N+1];
//            int[][] status = new int[N+1][N+1];
//            for(int i=0;i<N;i++){
//                dp[i][i] = nums[i];
//                status[i][i] = i;
//            }
//            for(int i=1;i<N;i++){
//                for(int j=0;j<N-i;j++){
//                    int a = nums[i]+(status[j+1][j+i]==j+1?dp[j+2][j+i]:dp[j+1][j+i-1]);
//                    int b = nums[j+i] + (status[j][j+i-1]==j?dp[j+1][j+i-1]:dp[j][j+i-2]);
//                    if(a>b){
//                        dp[j][j+i]=a;
//                        status[j][j+i]=j;
//                    }else{
//                        dp[j][j+i]=b;
//                        status[j][j+i]=j+i;
//                    }
//                }
//            }
//            System.out.println(dp[0][N-1]);
//
//        }
//    }
//
//}
