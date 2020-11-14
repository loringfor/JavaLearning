package com.interview.京东;

import java.util.*;

public class 考场安排 {
//    static final int N=(int)2e3+50;
//    static final int M=(int)1e4+50;
//    static int n,m,u,v;
//    static int cnt;
//    static int[] head=new int[N],link=new int[N];
//    static boolean[] vis=new boolean[N];
//    static Edge[] edges=new Edge[2*M];
//    static class Edge{
//        int v,next;
//
//        public Edge(int v,int next) {
//            this.v = v;
//            this.next = next;
//        }
//    }
//
//    static void init(){
//        cnt=0;
//        Arrays.fill(head,-1);
//    }
//
//    static void addEdge(int u,int v){
//        edges[cnt]=new Edge(v,head[u]);
//        head[u]=cnt++;
//        edges[cnt]=new Edge(u,head[v]);
//        head[v]=cnt++;
//    }
//
//    static boolean dfs(int u){
//        for(int i=head[u];i!=-1;i=edges[i].next) {
//            int v = edges[i].v;
//            if (!vis[v]) {
//                vis[v] = true;
//                if(link[v]==-1 || dfs(link[v])){
//                    link[v]=u;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    static int hungary(){
//        int res=0;
//        Arrays.fill(link,-1);
//        for(int i=1;i<=n;i++){
//            Arrays.fill(vis,false);
//            if(dfs(i)){
//                res++;
//            }
//        }
//        return res/2;
//    }
//
//    public static void main(String[] args) {
//        Scanner cin=new Scanner(System.in);
//        n=cin.nextInt();
//        m=cin.nextInt();
//        init();
//        while(m-->0){
//            u=cin.nextInt();
//            v=cin.nextInt();
//            addEdge(u,v);
//        }
//        int ans=hungary();
//        System.out.println(ans);
//        System.out.println(ans);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] nums = new int[m][2];
            Set<Integer> set = new HashSet();
            for(int i=0; i<m; i++){
//                nums[i][0]=in.nextInt();
//                nums[i][1]=in.nextInt();
                int min = Math.min(in.nextInt(),in.nextInt());
                set.add(min);
            }

            System.out.println(set.size());
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            System.out.println(1);
        }
    }
}
