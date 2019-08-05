package com.loring.dp;

public class 多重背包 {
    public static int getMaxValue(int[] weight, int[] value, int w, int n, int[] num) {
        //初始化动态规划数组
        int[][] dp = new int[n + 1][w + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                    System.out.print(dp[i][j]+ " ");
                }
                else {
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i - 1], j / weight[i - 1]);
                    for (int k = 0; k < maxV + 1; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                    }
                    System.out.print(dp[i][j]+ " ");
                }
            }
            System.out.println();
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
//        int n = 5, w = 10;                    //物品个数，背包容量
//        int[] value = {6, 3, 5, 4, 6};     //各个物品的价值
//        int[] weight = {2, 2, 6, 5, 4};    //各个物品的重量
//        int[] num = {1, 2, 3, 4, 5};    //各个物品能使用次数
        int n = 3, w = 100;                    //物品个数，背包容量
        int[] value = {100,1,2};     //各个物品的价值
        int[] weight = {26, 5, 5};    //各个物品的重量
        int[] num = {4,4,2};    //各个物品能使用次数
        System.out.println(getMaxValue(weight, value, w, n, num));
    }
}
