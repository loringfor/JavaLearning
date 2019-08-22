package com.interview.leetcode;

public class 打家劫舍II213 {

    public int rob(int[] nums){
        if(nums==null || nums.length<1)
            return 0;
        int len = nums.length;
        if(len==1)
            return nums[0];
        else if(len==2)
            return Math.max(nums[0],nums[1]);
        int dp1 = core(nums,0,len-2);
        int dp2 = core(nums,1,len-1);
        return Math.max(dp1,dp2);
    }


    public int core(int[] nums,int first,int end) {
        if(nums==null || nums.length<1)
            return 0;
        int len=end-first+1;
        if(len==1)
            return nums[first];
        int[] dp = new int[len];
        dp[0]=nums[first];
        dp[1]=Math.max(nums[first],nums[first+1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i+first]);
        }
        return dp[len-1];
    }

}
