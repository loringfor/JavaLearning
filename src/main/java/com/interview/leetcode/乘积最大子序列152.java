package com.interview.leetcode;

public class 乘积最大子序列152 {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    /**
     * 当负数个数为偶数时候, 全部相乘一定最大
     *
     * 当负数个数为奇数时候, 它的左右两边的负数个数一定为偶数, 只需求两边最大值
     *
     * 当有0情况,重置就可以了
     *
     */
    public static int maxProduct1(int[] nums){
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

}
