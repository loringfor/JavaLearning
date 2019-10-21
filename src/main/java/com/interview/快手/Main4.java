package com.interview.快手;

import java.util.Arrays;
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
            Arrays.sort(nums);
            int max=2;
            for(int i=0;i<len;i++){
                int temp=0;
                if(i+1<len){
                    temp = nums[i+1]-nums[i];
                }else {
                    break;
                }
                for(int j=i+1;j<len;j++){
                    if(nums[j]-nums[j-1]==temp){
                        max = Math.max(j-i+1,max);
                    }else{
                        break;
                    }
                }
            }
            System.out.println(max);
        }
    }


}
