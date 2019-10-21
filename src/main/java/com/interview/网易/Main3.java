package com.interview.网易;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] res = new int[n];

            for(int i=0;i<n;i++){
                int len = in.nextInt();
                int[] nums = new int[len];
                for(int j=0;j<len;j++){
                    nums[j] = in.nextInt();
                }
                res[i] = core(nums);
            }

            for(int i=0;i<n;i++){
                System.out.println(res[i]);
            }
        }
    }

//    2
//    5
//    1 3 9 2 6
//    5
//    4 2 9 16 7
    public static int core(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        boolean[] flag = new boolean[len];
        dp[0] = nums[0];
        flag[0]=true;
        int count=1,res=0;
        for(int i=1;i<len;i++){
            if(nums[i]>=dp[i-1] && flag[i-1]==true){
                count++;
                flag[i] = true;
                dp[i]=dp[i-1]+nums[i];
            }else{
                count=1;
                dp[i] = nums[i];
                flag[i] = true;
            }
            res = Math.max(res,count);
        }
        return res;
    }

}
