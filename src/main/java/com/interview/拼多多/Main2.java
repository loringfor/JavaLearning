package com.interview.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            // 10
            int L = in.nextInt();
            // 5
            int N = in.nextInt();
            int[] nums = new int[N];
            // 1 3 5 7 9
            for(int i = 0;i<N;i++){
                nums[i] = in.nextInt();
            }

            int[] temp = new int[N];
            Arrays.sort(nums);
            int max = Integer.MIN_VALUE;
            for(int i=1;i<nums.length;i++){
                temp[i-1] = nums[i]-nums[i-1];
                max = Math.max(max,temp[i-1]);
            }
            temp[N-1] = nums[0]+(L-nums[N-1]);

            if(max>temp[N-1]){
                // 朝两边移动

            }else{
                // 求中位数
                int middle = nums[0]+nums[N-1]+1 >>1;


            }


//            System.out.println(a + " " +b);
        }
    }
}
