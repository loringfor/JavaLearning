package com.interview.leetcode;

import java.util.*;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length<1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len=0;
        for(int i=0;i<nums.length;i++){
            int index = Arrays.binarySearch(dp,0,len,nums[i]);
            if(index<0){
                index =-(index+1);
            }
            dp[index]=nums[i];
            if(len==index){
                len++;
            }
        }
        return len;
    }
}
