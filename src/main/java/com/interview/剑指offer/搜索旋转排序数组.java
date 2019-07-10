package com.interview.剑指offer;

public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length<1)
            return -1;
        int left=0, right=nums.length-1;
        int middle;
        while(left<right){
            middle=(left+right)/2;
            if(target==nums[middle])
                return middle;
            if(nums[left]<=nums[middle]){
                if(target>=nums[left] && target<=nums[middle])
                    right=middle-1;
                else
                    left=middle+1;
            }
            if(nums[middle]<=nums[right]){
                if(target>=nums[middle] && target<=nums[right])
                    left=middle+1;
                else
                    right=middle-1;
            }
        }
        return nums[left]==target ? left: -1;
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
}
