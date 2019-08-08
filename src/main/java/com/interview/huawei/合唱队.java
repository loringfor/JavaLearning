package com.interview.huawei;

import java.util.*;

public class 合唱队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            int[] left = new int[len];
            int[] right = new int[len];
            //8
            //186 186 150 200 160 130 197 200
            for(int i=0;i<len;i++){
                nums[i] = in.nextInt();
                left[i] = 1;
                right[i] = 1;
            }

            for(int i=0;i<len;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j] && left[j]+1>left[i]){
                        left[i]=left[j]+1;
                    }
                }
            }

            for(int i=len-1;i>=0;i--){
                for(int j=len-1;j>i;j--){
                    if(nums[i]>nums[j] && right[j]+1>right[i]){
                        right[i]=right[j]+1;
                    }
                }
            }

            int max=Integer.MIN_VALUE;
            for(int i=0;i<len;i++){
                max = (left[i]+right[i]>max)?left[i]+right[i]:max;
            }

            System.out.println(len-max+1);

        }
    }


}
