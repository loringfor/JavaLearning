package com.loring.dp;

public class 走格子 {

    public static int sumCell(int[][] array){
        if(array.length==0)
            return 0;
        int row=array.length;
        int col=array[0].length;
        int[][] dp = new int[10005][10005];
        dp[0][0]=0;
        for(int i=1;i<row;i++)
            dp[i][0]=1;
        for(int i=1;i<col;i++)
            dp[0][i]=1;
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }

    // 有障碍，无障碍的array为0
    public static int sumCellHasBarrier(int[][] array){
        if(array.length==0)
            return 0;
        int row=array.length;
        int col=array[0].length;
        int[][] dp = new int[10005][10005];
        if(array[0][0]==0)
            dp[0][0]=1;
        else
            dp[0][0]=0;
        for(int i=1;i<row;i++){
            if(array[i][0]==0)
                dp[i][0]=dp[i-1][0];
            else
                dp[i][0]=0;
        }
        for(int i=1;i<col;i++){
            if(array[0][i]==0)
                dp[0][i]=dp[0][i-1];
            else
                dp[0][i]=0;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(array[i][j]==0)
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                else
                    dp[i][j]=0;
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        System.out.println(sumCellHasBarrier(new int[6][6]));
    }
}
