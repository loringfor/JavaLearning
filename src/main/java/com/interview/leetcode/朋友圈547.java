package com.interview.leetcode;

import java.util.*;

public class 朋友圈547 {
//    1 1 0
//    1 1 0
//    0 0 1
    public static int core(int[][] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(i)) {
                BFS(nums, i, list, set);
                res++;
            }
        }
        return res;
    }

    public static void BFS(int[][] nums, int i, LinkedList<Integer> list, Set<Integer> set) {
        list.addLast(i);
        while(!list.isEmpty()) {
            Integer temp = list.removeFirst();
            set.add(temp);
            for(int k = 0; k < nums[temp].length; k++) {
                if(nums[temp][k] == 1 && !set.contains(k)) {
                    list.addLast(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[][] nums = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0;j<N;j++){
                    nums[i][j]=in.nextInt();
                }
            }
            int res = core(nums);
            System.out.println(res);
        }
    }
}

