package com.interview.pdd;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] nums = new int[M][2];
            for(int i=0;i<M;i++){
                nums[i][0] = in.nextInt();
                nums[i][1] = in.nextInt();
            }
            int[] res = new int[M];
            boolean[] flag = new boolean[N+1];
            for(int i=0;i<M;i++){
                if(i>0){
                    res[i] = res[i-1];
                }
                for(int j=nums[i][0];j<=nums[i][1];j++){
                    if(flag[j]==false){
                        res[i]++;
                        flag[j]=true;
                    }
                }
            }
            for(int i=0;i<M;i++){
                System.out.println(res[i]);
            }
        }
    }
}
