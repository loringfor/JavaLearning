package com.interview.贝壳;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static int core(int[] nums){
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>=nums[j]*0.9){
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0;i<len;i++){
                nums[i]=in.nextInt();
            }
            int res = core(nums);
            System.out.println(res);
        }
    }
}
