package com.interview.leetcode;

public class 跳跃游戏55 {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len<=1)
            return true;
        int max=0;
        for(int i=0;i<len;i++){
            if(i>max)
                return false;
            max = Math.max(max,nums[i]+i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
