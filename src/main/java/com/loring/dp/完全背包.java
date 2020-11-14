package com.loring.dp;

public class 完全背包 {
    public static int getMaxValue(int[] weight, int[] value, int V, int N){
        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                    System.out.print(dp[i][j]+ " ");
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
                    System.out.print(dp[i][j]+ " ");
                }
            }
            System.out.println();
        }
        return dp[N][V];
    }

    // 优化后
    public static int getMaxValue1(int[] weight, int[] value, int V, int N) {
        int[] dp = new int[V+1];
        for(int i=1;i<=N;i++){
            for(int j=weight[i-1];j<=V;j++){
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
        System.out.println(getMaxValue(weight,value,V,N));
    }
}
