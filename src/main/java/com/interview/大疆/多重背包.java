package com.interview.大疆;

import java.util.*;
public class 多重背包 {
    /* 二进制优化

     */
    static class Item{
        private int v;
        private int w;
        public Item(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = 0;
        int bag = 0;
        ArrayList<Item> items = new ArrayList<Item>();
        int v = 0,w = 0,s = 0;

        while(in.hasNext()){
            len = in.nextInt();
            bag = in.nextInt();
            items = new ArrayList<Item>();
            for(int i = 0;i<len;i++){
                v = in.nextInt();
                w = in.nextInt();
                s = in.nextInt();
                for(int k = 1;k<=s;k*=2){
                    s-=k;
                    items.add(new Item(v*k,w*k));
                }
                if(s>0) items.add(new Item(v*s,w*s));
            }
            int[] f = new int[bag+1];
            for(int i=0;i<items.size();i++)
                for(int j=bag;j>=items.get(i).v;j--)
                    f[j] = Math.max(f[j],f[j-items.get(i).v]+items.get(i).w);
            System.out.println(f[bag]);

        }
    }
}