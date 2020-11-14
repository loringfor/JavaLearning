package com.interview.作业帮;

import java.util.*;
public class Main3 {
    public static int core(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            str = str.trim();
            str = str.substring(1, str.length() - 1);
            if (str.length() == 0) {
                System.out.println(0);
            }
            String[] strs = str.split(",");
            int[] nums = new int[strs.length];
            for(int index = 0; index < nums.length; index++) {
                String part = strs[index].trim();
                nums[index] = Integer.parseInt(part);
            }
            System.out.println(core(nums));
        }
    }
}
