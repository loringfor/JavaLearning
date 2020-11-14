package com.interview.leetcode;

public class 排序数组中查找元素的第一个和最后一个位置34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums==null || nums.length<1){
            return res;
        }
        int len =nums.length;
        int left=0,right=len-1;
        int middle;

        while(left<right){
            middle = left+right >>1;
            if(nums[middle]<target){
                left=middle+1;
            }else{
                right=middle;
            }
        }

        if(nums[left]==target){
            res[0]=left;
        }

        left=0;
        right=len-1;
        while(left<right){
            middle = left+right+1>>1;
            if(nums[middle]<=target){
                left=middle;
            }else{
                right=middle-1;
            }
        }
        if(nums[right]==target){
            res[1]=right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums ={5,7,7,8,8,10};
        int[] res = searchRange(nums,8);
        System.out.println(res[0]+","+res[1]);
    }
}
