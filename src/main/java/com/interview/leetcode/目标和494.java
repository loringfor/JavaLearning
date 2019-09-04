package com.interview.leetcode;

public class 目标和494 {
    // 通过递归来求解
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums,0,S,0);
    }

    public int findTargetSumWays(int[] nums,int index,int S,int sum){
        int res=0;
        if(index==nums.length){
            return sum==S?res+1:res;
        }
        res+=findTargetSumWays(nums,index+1,S,sum+nums[index]);
        res+=findTargetSumWays(nums,index+1,S,sum-nums[index]);
        return res;
    }

    /**
     通过01背包来求解
    当前元素等于1时，dp[9] = dp[9] + dp[9-1]
              dp[8] = dp[8] + dp[8-1]
               ...
              dp[1] = dp[1] + dp[1-1]

   当前元素等于2时，dp[9] = dp[9] + dp[9-2]
              dp[8] = dp[8] + dp[8-2]
               ...
              dp[2] = dp[2] + dp[2-2]
   当前元素等于3时，dp[9] = dp[9] + dp[9-3]
              dp[8] = dp[8] + dp[8-3]
               ...
              dp[3] = dp[3] + dp[3-3]
   当前元素等于4时，
               ...
   当前元素等于5时，
              ...
              dp[5] = dp[5] + dp[5-5]
   最后返回dp[9]即是所求的解
     */
    public static int findTargetSumWay(int[] nums,int S){
        if(nums==null||nums.length<1) {
            return 0;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(S>sum || ((sum+S)&1)==1) {
            return 0;
        }
        int target = (sum+S) >> 1;
        // dp[i]表示子集合元素之和等于当前目标值的方案个数
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
