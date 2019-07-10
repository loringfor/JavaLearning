package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 根据身高重建队列406 {
    public int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length) return new int[0][0];
        //按照身高降序 K升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        for (int i=0;i<people.length;i++) {
            list.add(people[i]);
        }
        int[] temp = new int[2];
        for(int i=0;i<list.size();i++){
            temp = list.get(i);
            list.remove(i);
            list.add(temp[1],temp);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

    }
}
