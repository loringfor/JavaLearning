package com.interview.云从科技;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String nums1 = in.nextLine();
            String num = in.nextLine();
            int amount = Integer.parseInt(num);
            nums1 = nums1.substring(1,nums1.length()-1);
            if("".equals(nums1)){
                System.out.println(0);
                continue;
            }
            String[] strs1 = nums1.split(",\\s+");
            int[] coins = new int[strs1.length];
            for(int i=0;i<strs1.length;i++){
                coins[i] = Integer.parseInt(strs1[i]);
            }
            int res = core(coins,amount);
            System.out.println(res);

        }
    }

    public static int core(int[] coins,int amount){
        int[] dp = new int[amount+1];
        int max =amount+1;
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount] < max){
            return dp[amount];
        }else {
            return -1;
        }
    }
}
