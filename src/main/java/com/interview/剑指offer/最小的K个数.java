package com.interview.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList();
        if(input==null || input.length<1)
            return list;
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int count=k;
        for(int i=0;i<input.length;i++){
            if(count>0){
                queue.add(input[i]);
                count--;
            }else{
                if(input[i]<queue.peek()){
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }

        for(int i=0;i<k;i++){
            list.add(queue.poll());
        }

        Collections.reverse(list);
        return list;
    }
}
