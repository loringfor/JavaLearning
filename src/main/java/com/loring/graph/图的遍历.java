package com.loring.graph;

import java.util.LinkedList;
import java.util.Queue;

// 输入一个邻接矩阵，打印所有的节点
public class 图的遍历 {
    public static String[] vertexs = { "A", "B", "C", "D", "E", "F" };

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0 }
        };

        DFSTraverse(edges);
        System.out.println();
        BFSTraverse(edges);
    }

    public static void DFSTraverse(int[][] edges){
        boolean[] visited = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(visited[i]==false)
                DFS(edges,i,visited);
        }
    }

    public static void DFS(int[][] edges,int i,boolean[] visited){
        System.out.print(vertexs[i]+" ");
        visited[i] = true;
        for(int j=0;j<edges[i].length;j++){
            if(edges[i][j]==1 && !visited[j]){
                DFS(edges,j,visited);
            }
        }
    }

    public static void BFSTraverse(int[][] edges){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        queue.add(0);
        while (!queue.isEmpty()){
            int temp = queue.poll();
            visited[temp]=true;
            System.out.print(vertexs[temp]+" ");
            for(int j=0;j<edges.length;j++){
                if(!visited[j] && edges[temp][j]==1)
                    queue.add(j);
            }
        }
    }

}
