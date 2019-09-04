package com.interview.leetcode;

public class 最短无序连续子数组581 {

    public static int findUnsortedSubarray(int[] nums) {
        int length=nums.length;
        if(nums==null || length<1)
            return 0;
        int left=-1,right=-2;
        int m=nums[0],n=nums[length-1];
        for(int i=1;i<length;i++){
            m = Math.max(m, nums[i]);
            n = Math.min(n, nums[length - 1 - i]);
            if (m != nums[i])
                right = i;
            if (n != nums[length - 1 - i])
                left = length - 1 - i;
        }
        return right-left+1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
