package com.interview.回溯法;

public class 矩阵中的路径 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j< cols ; j++) {
                boolean[] visited = new boolean[rows*cols] ;
                if(backTrack(matrix,rows,cols,str,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backTrack(char[] matrix, int rows, int cols, char[] str,int i,int j,int length,boolean[] visited){
        if(length==str.length){
            return true;
        }
        if(i>=0 && i<rows && j>=0 && j<cols && visited[i*cols+j]==false && matrix[i*cols+j]==str[length]){
            visited[i*cols+j]=true;
            return backTrack(matrix,rows,cols,str,i+1,j,length+1,visited)||
                    backTrack(matrix,rows,cols,str,i,j+1,length+1,visited) ||
                    backTrack(matrix,rows,cols,str,i-1,j,length+1,visited) ||
                    backTrack(matrix,rows,cols,str,i,j-1,length+1,visited);
        }
        return false;
    }

    public static void main(String[] args) {
        String string = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        char[] matrix = string.toCharArray();
        String str1 = "SGGFIECVAASABCEHJIGQEM";
        char[] str= str1.toCharArray();
        System.out.println(hasPath(matrix,5,8, str));
    }
}
