package com.interview.leetcode;

import java.util.*;

public class 括号生成22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        int open=0, close=0;
        backTrack(res,"",open,close,n);
        return res;
    }

    public static void backTrack(List<String> res, String cur, int open, int close, int n){
        if(cur.length()==2*n){
            res.add(cur);
            return;
        }
        if(open<n){
            backTrack(res,cur+"(",open+1,close,n);
        }
        if(close<open){
            backTrack(res,cur+")",open,close+1,n);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
