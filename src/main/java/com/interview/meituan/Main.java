package com.interview.meituan;

import java.util.*;
public class Main {
    public static void main(String args[]){
        DPTree dpTree=new DPTree();
        dpTree.input();
        dpTree.dfs(-1,0);
        System.out.println(dpTree.dp[0][1]);
    }
}

class DPTree {
    final static int N=1024;
    final static long mod=1000000007;
    ArrayList<ArrayList<Integer>> list;
    public long dp[][]=new long[N][2];
    int[] color;
    int[] father;
    int n;

    public void input(){
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        color = new int[n];
        father = new int[n-1];
        list=new ArrayList<>();
        for(int i=0;i<n-1;i++) {
            father[i]=in.nextInt();
        }
        for(int i=0;i<n;i++) {
            color[i]=in.nextInt();
            list.add(new ArrayList<Integer>());
            Arrays.fill(dp[i],0);
        }
        for(int i=0;i<n-1;i++) {
            list.get(i+1).add(father[i]);
            list.get(father[i]).add(i+1);
        }
    }

    public void dfs(int f,int u) {
        dp[u][color[u]]=1;
        dp[u][color[u]^1]=0;
        ArrayList<Integer> tmp=list.get(u);
        for(Integer v:tmp) {
            if(v==f) continue;
            dfs(u,v);
            dp[u][1]=((((dp[v][0]+dp[v][1])%mod)*dp[u][1])%mod+dp[u][0]*dp[v][1])%mod;
            dp[u][0]=((dp[v][0]+dp[v][1])%mod)*dp[u][0]%mod;//dp[v][0]表示加边，dp[v][1]表示删边
        }
    }
}