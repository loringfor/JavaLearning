package com.interview.leetcode;

public class 分割等和子集416 {
    public static boolean canPartition(int[] nums) {
        if(nums==null || nums.length<1)
            return false;
        int len = nums.length;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if((sum&1)==1){
            return false;
        }
        int target= sum>>1;

        boolean[][] dp = new boolean[len+1][target+1];
        dp[0][0]=true;
        for(int i=1;i<=len;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        for(int i=0;i<=len;i++){
            for(int j=0;j<=target;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[len][target];
    }

    public static void main(String[] args) {
        int[] nums={1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
