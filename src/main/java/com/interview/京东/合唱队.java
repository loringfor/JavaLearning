package com.interview.京东;

import java.util.*;

public class 合唱队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0; i<len; i++){
                nums[i]=in.nextInt();
            }

            int max = nums[0];
            int count=1;
            for(int i=1;i<nums.length;i++){
                if(nums[i]>max){
                    max=nums[i];
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
