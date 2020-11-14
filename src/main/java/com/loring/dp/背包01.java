package com.loring.dp;

public class 背包01 {
    // 未优化
    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i-1] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    dp[i][j] = dp[i - 1][j];
                    System.out.print(dp[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + value[i-1]);
                    System.out.print(dp[i][j]+ " ");
                }
            }
             System.out.println();
        }
        return dp[n][w];
    }

    // 优化后
    public static int getMaxValue1(int[] weight, int[] value, int V, int N) {
        int[] dp = new int[V+1];
        for(int i=1;i<=N;i++){
            for(int j=V;j>=weight[i-1];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i-1]] + value[i-1]);
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
        return dp[V];
    }
    public static void main(String[] args) {
        int N = 5, V = 10;                    //物品个数，背包容量
        int[] value = {6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue1(weight,value,V,N));
    }
}
