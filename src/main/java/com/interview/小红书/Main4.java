package com.interview.小红书;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[][] nums = new int[n][2];
            for(int i = 0; i < n; i++){
                nums[i][0] = in.nextInt();
                nums[i][1] = in.nextInt();
            }
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
                }
            });

            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for(int i=1; i<n; i++){
                int maxval = 0;
                for(int j=0; j<i; j++){
                    if(nums[i][1] >= nums[j][1]){
                        maxval  = Math.max(maxval, dp[j]);
                    }
                }
                dp[i] = Math.max(maxval + 1, dp[i]);
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }
}