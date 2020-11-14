package com.interview.leetcode;

import java.util.*;

public class 每日温度739 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[T.length];
        stack.push(0);
        for(int i=1;i<T.length;i++){
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int temp=stack.pop();
                res[temp]=i-temp;
            }
            stack.push(i);
        }
        return res;
    }

}
