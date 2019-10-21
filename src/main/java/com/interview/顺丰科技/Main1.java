package com.interview.顺丰科技;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0; i<len; i++){
                nums[i]=in.nextInt();
            }
            int max_num=10000;
            double[] s = new double[max_num];
            s[4] = 2;
            s[5] = 2.5;

            int i=6;
            int beishu=2;
            while(i<max_num){
                s[i] = s[i-1] + beishu - 0.5;
                i += 1;
                if(i<max_num){
                    s[i] = s[i-1] + beishu + 0.5;
                    i += 1;
                }
                if(i<max_num){
                    s[i] = s[i-1] + beishu - 0.5;
                    i += 1;
                }
                if(i<max_num){
                    s[i] = s[i-1] + beishu + 0.5;
                    i += 1;
                }
                beishu++;
            }

            for(int m=0;m<nums.length;m++){
                for(int j=0;j<max_num;j++){
                    if(s[j]>=nums[m]){
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
    }
}
