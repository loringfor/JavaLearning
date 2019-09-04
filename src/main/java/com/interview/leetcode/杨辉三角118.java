package com.interview.leetcode;

import java.util.*;

public class 杨辉三角118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            tmp.add(0, 1);
            for (int j = 1; j < tmp.size() - 1; j++) {
                tmp.set(j, tmp.get(j) + tmp.get(j + 1));
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}
