package com.interview.作业帮;

import java.util.*;

public class Main1 {

    public static List<int[]> core(int[] nums, int target) {
        Set<Integer> set = new HashSet();
        List<int[]> res = new ArrayList<>();
        if(nums==null || nums.length<1) {
            return res;
        }
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(set.contains(temp)){
                res.add(new int[]{temp,nums[i]});
            }
            set.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            if(str.length()>2){
                str= str.substring(1,str.length()-1);
                String[] strs = str.split(",");
                int[] nums = new int[strs.length];
                for(int i=0;i<strs.length;i++){
                    nums[i]=Integer.parseInt(strs[i]);
                }
                int target = in.nextInt();
                List<int[]> res = core(nums,target);
                if(res.size()>=1){
                    for(int i=res.size()-1;i>=0;i--){
                        System.out.println(res.get(i)[0]+","+res.get(i)[1]);
                    }
                }else {
                    System.out.println();
                }
            }else {
                System.out.println();
            }
        }
    }
}

