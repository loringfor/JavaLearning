package com.interview.leetcode;

import java.util.*;

public class 子集78 {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums,0,res,new ArrayList<>());
        return res;
    }

    public static void backTrace(int[] nums,int cur,List<List<Integer>> res,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=cur;i<nums.length;i++){
            list.add(nums[i]);
            backTrace(nums,cur+1,res,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};

    }
}
