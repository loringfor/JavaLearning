package com.interview.剑指offer;


import java.util.*;

public class 顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList();
        if(matrix==null || matrix.length<1)
            return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int left=0,right=col-1,top=0,bootom=row-1;
        while(left<=right && top<=bootom){
            for(int i=left;i<=right;i++)
                list.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bootom;i++)
                list.add(matrix[i][right]);
            right--;
            if(left<=right && top<=bootom){
                for(int i=right;i>=left;i--)
                    list.add(matrix[bootom][i]);
                bootom--;
            }
            if(top<=bootom && left<=right){
                for(int i=bootom;i>=top;i--)
                    list.add(matrix[i][left]);
                left++;
            }
        }
        return list;
    }
}
