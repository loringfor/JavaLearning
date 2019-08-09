package com.interview.leetcode;

public class 颜色分类75 {
    public static void sortColors(int[] nums) {
        // 三指针
        int i=0, left=0, right=nums.length-1;
        while(i<=right){
            if(i<left || nums[i]==1){
                i++;
            }
            else if(nums[i]==0){
                swap(nums,i,left);
                left++;
            }
            else if(nums[i]==2){
                swap(nums,i,right);
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        if(i==j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
