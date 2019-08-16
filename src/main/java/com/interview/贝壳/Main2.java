package com.interview.贝壳;

import java.util.*;

public class Main2 {

    public static int core(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        int[] dp = new int[nums.length];
        int len=0;
        for(int i=0;i<nums.length;i++){
            int index = Arrays.binarySearch(dp,0,len,nums[i]);
            if(index<0){
                index =-(index+1);
            }
            dp[index]=nums[i];
            if(len==index){
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0;i<len;i++){
                nums[i]=in.nextInt();
            }
            int res = core(nums);
            System.out.println(res);
        }
    }
}

