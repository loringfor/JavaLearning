package com.interview.leetcode;


import java.util.*;

public class 组合总和39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates==null || candidates.length<1){
            return res;
        }
        Arrays.sort(candidates);
        findCombination(res,candidates,target,0,new Stack<Integer>());
        return res;
    }

    public static void findCombination(List<List<Integer>> res,int[] candidates,
                                int target,int start,Stack<Integer> stack){
        if(target==0){
            res.add(new ArrayList(stack));
            return;
        }
        for(int i=start; i<candidates.length && target-candidates[i]>=0; i++){
            stack.add(candidates[i]);
            findCombination(res,candidates,target-candidates[i],i,stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinationSum =combinationSum(candidates, target);
        System.out.println(combinationSum);
    }

}
