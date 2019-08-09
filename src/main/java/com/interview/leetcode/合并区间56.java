package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals==null || intervals.length<1){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int i=0;
        while (i<intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<intervals.length-1 && intervals[i+1][0]<=right){
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] nums= {{1,4},{0,4}};

    }
}
