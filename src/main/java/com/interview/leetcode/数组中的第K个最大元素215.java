package com.interview.leetcode;

import java.util.PriorityQueue;

public class 数组中的第K个最大元素215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(i<k){
                queue.add(nums[i]);
            }else {
                if(nums[i]>queue.peek()){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
