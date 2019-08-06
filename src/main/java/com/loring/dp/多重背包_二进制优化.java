package com.loring.dp;

import java.util.*;
public class 多重背包_二进制优化{

    /**
     * 多重背包，采用二进制优化
     */
    static class Item{
        private int weight; // 体积
        private int value; // 价值
        public Item(int weight,int value){
            this.weight=weight;
            this.value=value;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // 物品种类
        int len = 0;
        // 背包容积
        int bag = 0; 
        ArrayList<Item> items = new ArrayList<Item>();
        int weight = 0,value = 0,num = 0;

        while(in.hasNext()){
            len = in.nextInt();
            bag = in.nextInt();
            items = new ArrayList<>();

            for(int i = 0;i<len;i++){
                weight = in.nextInt();
                value = in.nextInt();
                num = in.nextInt();
                for(int k = 1;k<=num;k*=2){
                    num-=k;
                    items.add(new Item(weight*k,value*k));
                }
                if(num>0){
                    items.add(new Item(weight*num,value*num));
                }
            }

            int[] dp = new int[bag+1];
            for(int i=0;i<items.size();i++){
                for(int j=bag;j>=items.get(i).weight;j--) {
                    dp[j] = Math.max(dp[j],dp[j-items.get(i).weight]+items.get(i).value);
                }
            }
            System.out.println(dp[bag]);
        }
    }
}