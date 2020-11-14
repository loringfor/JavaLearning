package com.interview.leetcode;

public class 下一个排列31 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)
            return;
        int left=0,right=0;
        boolean flag=true;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                flag=false;
                left=i-1;
                while(i<nums.length && nums[i]>nums[left]){
                    i++;
                }
                right=i-1;
                swap(nums,left,right);
                break;
            }
        }
        if(flag){
            reverse(nums,0);
        }else{
            reverse(nums,left+1);
        }

    }

    public void reverse(int[] nums,int start){
        int left=start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
