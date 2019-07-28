package com.interview.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 最长不含重复字符的子字符串 {
    public static int longestSubstringWithoutDuplication(String s) {
        if(s==null || s.length()<1)
            return 0;
        int len=s.length();
        int left=0;
        int right=0;
        int max=0;
        List<Character> list = new ArrayList();
        while(left<len && right<len){
            while(list.contains(s.charAt(right))){
                list.remove(0);
                left++;
            }
            list.add(s.charAt(right));
            right++;

            max=Math.max(max,right-left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("abcabc"));
    }
}
