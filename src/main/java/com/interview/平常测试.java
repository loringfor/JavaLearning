package com.interview;

import java.util.Arrays;

public class 平常测试 {

    public static void main(String[] args){
        int[] nums ={1,3,5,7,9};
        int res = Arrays.binarySearch(nums,0,0,2);
        System.out.println(res);
    }
}
