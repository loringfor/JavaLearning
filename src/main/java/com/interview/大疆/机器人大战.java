package com.interview.大疆;

import java.util.*;
public class 机器人大战{

//    public static int dijkstra(int[][] weight,int start,int end){
//        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
//        //返回一个int[] 数组，表示从start到它的最短路径长度
//        int n = weight.length;        //顶点个数
//        int[] shortPath = new int[n];    //存放从start到其他各点的最短路径
//        String[] path=new String[n]; //存放从start到其他各点的最短路径的字符串表示
//        for(int i=0;i<n;i++)
//            path[i]=new String(start+"-->"+i);
//        int[] visited = new int[n];   //标记当前该顶点的最短路径是否已经求出,1表示已求出
//
//        //初始化，第一个顶点求出
//        shortPath[start] = 0;
//        visited[start] = 1;
//        int dmin=0;
//        for(int count = 1;count <= n - 1;count++)  //要加入n-1个顶点
//        {
//
//            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
//            dmin= Integer.MAX_VALUE;
//            for(int i = 0;i < n;i++)
//            {
//                if(visited[i] == 0 && weight[start][i] < dmin)
//                {
//                    dmin = weight[start][i];
//                    k = i;
//                }
//            }
//            // System.out.println("k="+k);
//
//            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
//            shortPath[k] = dmin;
//
//            visited[k] = 1;
//
//            //以k为中间点，修正从start到未访问各点的距离
//            for(int i = 0;i < n;i++)
//            {
//                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
//                    weight[start][i] = weight[start][k] + weight[k][i];
//
//                    path[i]=path[k]+"-->"+i;
//
//                }
//
//            }
//
//        }
//
//        System.out.println("从"+start+"出发到"+end+"的最短路径为："+path[end]);
//
//        System.out.println("=====================================");
//
//        return dmin;
//    }

    public static int dijkstra(int[][] martix,int start,int terminal){
        boolean[] isVisted = new boolean[martix.length];
        int []d = new int[martix.length];
        for (int i = 0;i<martix.length;i++){
            isVisted[i] = false; //该点是否被计入，可以理解为判断该点是否已经加入集合B
            d[i] = Integer.MAX_VALUE;//在当前的集合B所能连接的路径中，从起始点到该点的最短路径
        }
        isVisted[start] = true;
        d[start] = 0;
        int unVisitNode = martix.length ;
        int index = start;
        while (unVisitNode > 0 && !isVisted[terminal] ){
            int min = Integer.MAX_VALUE;
            //选出集合A中的点到集合B的路径最短的点
            for (int i = 0;i<d.length;i++){
                if (min > d[i] && !isVisted[i]){
                    index = i;
                    min = d[i];
                }
            }

            for (int i = 0;i<martix.length;i++){
                if (d[index] + martix[index][i] < d[i]) //更新当前的最短路径
                    d[i] = d[index] + martix[index][i];
            }

            unVisitNode -- ;
            isVisted[index] = true;
        }

        return d[terminal];
//        System.out.println(d[terminal]);
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int p = in.nextInt();
            int c = in.nextInt();
            int[][] t = new int[n][n];
            int[] d = new int[c];
            // 初始化邻接矩阵
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    t[i][j]=Integer.MAX_VALUE;
            }

            for(int i =0;i<p;i++){
                int x = in.nextInt();
                int y = in.nextInt();
                int distance = in.nextInt();
                t[x][y] = distance;
                t[y][x] = distance;
            }

            for(int i =0;i<p;i++){
                d[i] = in.nextInt();
            }

            int res = 0;
            for(int i =0;i<p;i++){
                res+=dijkstra(t,0,d[i]);
            }
            System.out.println(res);
        }

        in.close();
    }
}
