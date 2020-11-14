package com.interview.leetcode;

import java.util.*;

public class 无重复最长字串3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<1) {
            return 0;
        }
        int res=0;
        int len = s.length();
        Set<Character> set = new HashSet();
        int i=0,j=0;
        while(i<len && j<len){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                i++;
                res = Math.max(res,i-j);
            }else{
                set.remove(s.charAt(j));
                j++;
            }
        }
        return res;
    }
}
