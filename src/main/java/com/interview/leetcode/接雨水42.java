package com.interview.leetcode;

public class 接雨水42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) {
                    res += left_max - height[left];
                } else{
                    left_max = height[left];
                }
                left++;
            } else {
                if (height[right] < right_max){
                    res += right_max - height[right];
                } else{
                    right_max = height[right];
                }
                right--;
            }
        }
        return res;
    }

}
