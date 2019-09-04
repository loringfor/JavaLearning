package com.interview.leetcode;

import java.util.*;

public class 和为K的连续子数组560 {

    public static int subarraySum(int[] nums, int k) {
        int len=nums.length;
        if(len<1) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0, count=0;
        for(int i=0;i<len;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums ={2,3,2,4};
        System.out.println(subarraySum(nums,5));
    }
}
