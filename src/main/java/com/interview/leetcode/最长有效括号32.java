package com.interview.leetcode;

import java.util.*;

public class 最长有效括号32 {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<1)
            return 0;
        Stack<Integer> stack = new Stack();
        int res =0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }
}
