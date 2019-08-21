package com.interview.leetcode;

public class 单词搜索79 {
    public static boolean exist(char[][] board, String word) {
        if(board==null || board.length<1)
            return false;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(backTrace(board,word,i,j,rows,cols,0,visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean backTrace(char[][] board,String word,int row,int col,int rows,int cols,int cur,boolean[][] visited){
        if(cur==word.length())
            return true;
        if(row>=0 && row<rows && col>=0 && col<cols && visited[row][col]==false && board[row][col]==word.charAt(cur)){
            visited[row][col]=true;
            if(backTrace(board,word,row-1,col,rows,cols,cur+1,visited) ||
                    backTrace(board,word,row+1,col,rows,cols,cur+1,visited) ||
                    backTrace(board,word,row,col-1,rows,cols,cur+1,visited) ||
                    backTrace(board,word,row,col+1,rows,cols,cur+1,visited))
                return true;
            visited[row][col]=false;
        }

        return false;

    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board,word));
    }
}
