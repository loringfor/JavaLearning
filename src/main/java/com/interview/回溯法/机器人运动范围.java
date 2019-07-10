package com.interview.回溯法;

public class 机器人运动范围 {
    public static int movingCount(int threshold, int rows, int cols){
        boolean[][] flag = new boolean[rows][cols];
        int sum=backTrack(threshold,0,0,rows,cols,flag);
        return sum;
    }

    public static int backTrack(int threshold,int row,int col,int rows,int cols,boolean[][] flag){
        if(row<0 || row>=rows || col<0 || col>=cols || splitNum(row)+splitNum(col)>threshold || flag[row][col]==true)
            return 0;
        flag[row][col]=true;
        return 1+ backTrack(threshold,row+1,col,rows,cols,flag)+
                backTrack(threshold,row,col+1,rows,cols,flag);
    }

    public static int splitNum(int num){
        int sum=0;
        while(num>0){
            sum += num%10;
            num /=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum=movingCount(4,4,5);
        System.out.println(sum);
    }
}
