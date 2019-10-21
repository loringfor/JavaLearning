package com.interview.bytedance;

import java.util.Scanner;

public class Main4 {

//    4 100
//    100 73 60
//    100 89 35
//    30 21 30
//    10 8 10   100
//
//    3 100
//    100 100 60
//    80 80 35
//    21 21 30   60
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int x = in.nextInt();
            int[][] nums = new int[n][3];
            for(int i=0;i<n;i++){
                nums[i][0] = in.nextInt();
                nums[i][1] = in.nextInt();
                nums[i][2] = in.nextInt();
            }

            int[] dp = new int[x+1];
            for(int i=1;i<=n;i++){
                for(int j=x;j>=nums[i-1][1];j--){
                    dp[j]=Math.max(dp[j],dp[j-nums[i-1][1]] + nums[i-1][2]);
                    System.out.print(dp[j]+" ");
                }
            }
            System.out.println(dp[x]);
        }
    }

}
