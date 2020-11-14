package com.interview.leetcode;

import java.util.*;

public class 格雷编码89 {

    // 一种动规的思想
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        res.add(0);
        int flag=1;
        for(int i=1;i<=n;i++){
            for(int j=res.size()-1;j>=0;j--){
                res.add(res.get(j)+flag);
            }
            flag=flag<<1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n=2;
        grayCode(n);
    }
}
