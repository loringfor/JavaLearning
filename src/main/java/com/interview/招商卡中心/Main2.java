package com.interview.招商卡中心;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[][] nums = new int[len-1][3];
            for(int i=0;i<len-1;i++){
                nums[i][0] = in.nextInt();
                nums[i][1] = in.nextInt();
                nums[i][2] = in.nextInt();
            }
            int[] res = new int[len];
            res[0]=len;
            res[1]=len/2;
            for(int i=0;i<len;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }


    }
}
