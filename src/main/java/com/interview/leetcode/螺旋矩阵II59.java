package com.interview.leetcode;

public class 螺旋矩阵II59 {
    public static int[][] generateMatrix(int n) {
        int k=1;
        int[][] res = new int[n][n];
        int left=0,right=n-1,top=0,bottom=n-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                res[top][i]=k++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res[i][right]=k++;
            }
            right--;
            if(left<=right && top<=bottom){
                for(int i=right;i>=left;i--){
                    res[bottom][i]=k++;
                }
                bottom--;
            }
            if(left<=right && top<=bottom){
                for(int i=bottom;i>=top;i--){
                    res[i][left]=k++;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generateMatrix(2);
    }
}
