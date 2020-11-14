package com.loring.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 图的最远节点 {
    public static int len;

    public static int bfs(int start, int num, int node[][]) {
        len = 0;
        boolean[] flag = new boolean[num+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        int m=start;
        flag[m] = true;
        while(!queue.isEmpty()) {
            System.out.println("before: "+queue);
            int size = queue.size();
            len++;
            System.out.println("length: "+len);
            for (int a = 0;a < size; a++) {
                m = queue.remove();
                for (int i = 1; i <= num; i++) {
//                System.out.println(node[m][i]);
                    if (node[m][i] == 1 && flag[i] == false) {
                        queue.add(i);
                        System.out.println("add: "+i);
                        flag[i] = true;
                    }
                }
            }

        }
        return m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int[][] node = new int[m+1][m+1];
            for (int j = 0; j < m-1; j++) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                node[n1][n2] = 1;
                node[n2][n1] = 1;
            }
            for (int y=1;y<=m;y++){
                for (int j=1;j<=m;j++)
                    System.out.print(node[y][j]+" ");
                System.out.println();
            }

            int end = bfs(1,m,node);
            System.out.println("bfs1: "+len);
            bfs(end,m,node);
            System.out.println("end: "+end);
            System.out.println("len: "+(len-1));

        }

    }
}

