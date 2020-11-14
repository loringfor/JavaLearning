package com.interview.网易;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0;i<len;i++){
                nums[i] = in.nextInt();
            }
            int res = 0;
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    if(nums[i]-nums[j]>0){
                        res += nums[i]-nums[j];
                    }
                }
            }
            System.out.println(res);
        }
    }

}
