package com.interview.bytedance;


import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] nums = new int[N];
            for(int i=0; i<N; i++){
                nums[i]=in.nextInt();
            }
            int res = getScores(nums);
            System.out.println(res);
        }
    }

    public static int getScores(int[] nums){
        int len =nums.length;
        int[][] a = new int[len][len];
        int[][] b = new int[len][len];
        for (int i=0;i<len;i++){
            a[i][i] = nums[i];
            for (int j=i-1;j>=0;j--){
                a[j][i] = Math.max(nums[j]+b[j+1][i],nums[i]+b[j][i-1]);
                b[j][i] = Math.min(a[j+1][i],a[j][i-1]);
            }
        }
        return Math.max(a[0][len-1],b[0][len-1]);
    }


}
