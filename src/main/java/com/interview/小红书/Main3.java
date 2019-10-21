package com.interview.小红书;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            
            int[][] dp=new int[2][n];
            dp[1][0]=nums[0];
            for(int i=1;i<n;i++){
                dp[0][i]=Math.max(dp[1][i-1],dp[0][i-1]);
                dp[1][i]=dp[0][i-1]+nums[i];
            }
            int max=Math.max(dp[0][n-1],dp[1][n-1]);
            int res=max;
            int count=0;
            for(int i=nums.length-1;i>=0;i--){
                if(res==dp[0][i]){
                    continue;
                } else {
                    count++;
                    res-=nums[i];
                }
            }
            System.out.println(max+" "+count);
        }
    }
}
