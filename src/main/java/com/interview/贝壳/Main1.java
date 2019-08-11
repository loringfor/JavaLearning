package com.interview.贝壳;

import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            long[] nums = new long[len];
            for(int i = 0;i<len;i++){
                nums[i] = in.nextLong();
            }
            long min = Long.MAX_VALUE;

            long a = 0,b = 0;
            for(int i = 1;i<len;i++){
                long temp = nums[i]-nums[i-1]>0?nums[i]-nums[i-1]:nums[i-1]-nums[i];
                if(temp <min){
                    a=nums[i-1];
                    b=nums[i];
                    min =temp;
                }
            }
            System.out.println(a + " " +b);
        }
    }
}
