package com.interview.剑指offer;

import java.util.Arrays;
import java.util.Comparator;

public class 把数组排成最小的数 {
    public String printMinNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str1.compareTo(str2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(String s:strs){
            stringBuilder.append(s);
        }

        return stringBuilder.toString();


    }
}
