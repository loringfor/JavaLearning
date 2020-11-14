package com.interview.剑指offer;

public class 正负的位置 {

    public static int[] find(int[] nums){
        int[] res = new int[2];
        int left=0, right=nums.length-1;
        int middle=0;
        while(left<right){
            middle = left+right >>1;
            if(nums[middle]<0 && nums[middle+1]>=0){
                res[0]=nums[middle];
                break;
            }
            if(nums[middle]<0)
                left = middle+1;
            else
                right = middle;
        }

        left = 0;
        right = nums.length-1;
        while(left<right){
            middle = left+right>>1;
            if(nums[middle]>0 && nums[middle-1]<=0){
                res[1]=nums[middle];
                break;
            }
            if(nums[middle]<=0)
                left=middle+1;
            else
                right=middle;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,1,2,3,5};
        int[] res = find(nums);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
