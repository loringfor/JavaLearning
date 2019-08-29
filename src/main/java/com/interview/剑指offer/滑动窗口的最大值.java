package com.interview.剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 1.判断当前最大值是否过期
 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 */
public class 滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) {
            return res;
        }
        int begin;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(queue.isEmpty())
                queue.add(i);
            else if(begin > queue.peekFirst())
                queue.pollFirst();

            while((!queue.isEmpty()) && num[queue.peekLast()] <= num[i])
                queue.pollLast();
            queue.add(i);
            if(begin >= 0)
                res.add(num[queue.peekFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array ={2,3,4,2,6,2,5,1};
        maxInWindows(array,3);
    }
}
