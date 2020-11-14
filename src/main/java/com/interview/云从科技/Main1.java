package com.interview.云从科技;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int candies = in.nextInt();
            int people = in.nextInt();
            int[] nums = new int[people];
            int i=0, num = 0;
            while(candies!=0){
                if(i>=people) {
                    i=0;
                }
                num++;
                if(candies>num){
                    nums[i] = nums[i]+num;
                    i++;
                    candies -= num;
                }else {
                    nums[i] = nums[i]+candies;
                    i++;
                    candies = 0;
                }
            }
            StringBuilder res = new StringBuilder("[");
            for(int j=0;j<nums.length;j++){
                res.append(nums[j]+",");
            }
            String ans = res.substring(0,res.length()-1);
            System.out.println(ans+"]");
        }
    }
}
