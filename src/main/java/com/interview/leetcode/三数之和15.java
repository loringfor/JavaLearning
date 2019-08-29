package com.interview.leetcode;

import java.util.*;

public class 三数之和15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> resList = new ArrayList();
        if(len<3)
            return resList;
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int left=i+1;
            int right=len-1;
            while(left<right){
                int temp=nums[i]+nums[left]+nums[right];
                if(temp==0){
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resList.add(list);
                    while(left<right && nums[left+1]==nums[left])
                        left++;
                    while(left<right && nums[right-1]==nums[right])
                        right--;
                    left++;
                    right--;
                }else if(temp<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums ={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);

    }
}
