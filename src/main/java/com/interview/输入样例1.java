package com.interview;

import java.util.*;

public class 输入样例1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0; i<len; i++){
                nums[i]=in.nextInt();
            }
        }
    }
}
