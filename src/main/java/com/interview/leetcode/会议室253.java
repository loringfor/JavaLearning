package com.interview.leetcode;

import java.util.*;

public class 会议室253 {

    // 有序Map
    public static int minMeetingRoomsWithmap(int[][] nums){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i][0], map.getOrDefault(nums[i][0],0) + 1);
            map.put(nums[i][1], map.getOrDefault(nums[i][1],0) - 1);
        }
        int res = 0,mid = 0;
        for (int m : map.values()) {
            mid += m;
            res = Math.max(res, mid);
        }
        return res;
    }

    // 最小堆
//    public static int minMeetingRoomsWithmap1(int[][] nums){
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
//        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.end - b.end);
//        heap.add(nums[0]);
//        for (int i = 1;i<nums.length;i++) {
//            Interval now = heap.poll();
//            if (nums[i][0] >= now.end) {
//                //时间不冲突，原最早结束的会议室，时间扩展即可。
//                now.end = nums[i].end;
//            }else {
//                //时间冲突，添加新的会议室。
//                heap.offer(nums[i]);
//            }
//            heap.offer(now);
//        }
//        return heap.size();
//    }

    public static void main(String[] args) {
        int[][] nums = {{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRoomsWithmap(nums));
    }
}
