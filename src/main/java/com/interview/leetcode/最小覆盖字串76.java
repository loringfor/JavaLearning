package com.interview.leetcode;

import java.util.*;

public class 最小覆盖字串76 {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : s.toCharArray()){
            lookup.put(c, 0);
        }
        for (char c : t.toCharArray()) {
            if (lookup.containsKey(c)){
                lookup.put(c, lookup.get(c) + 1);
            }
            else{
                return "";
            }
        }
        int start = 0;
        int end = 0;
        int min_len = Integer.MAX_VALUE;
        int counter = t.length();
        String res = "";
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (lookup.get(c1) > 0){
                counter--;
            }
            lookup.put(c1, lookup.get(c1) - 1);
            end++;
            while (counter == 0) {
                if (min_len > end - start) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                char c2 = s.charAt(start);
                if (lookup.get(c2) == 0){
                    counter++;
                }
                lookup.put(c2, lookup.get(c2) + 1);
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(minWindow(S,T));
    }
}
