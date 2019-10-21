package com.interview.bytedance;


import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] nums = new int[N];
            for(int i=0; i<N; i++){
                nums[i]=in.nextInt();
            }
            int K = in.nextInt();
            int res = core(nums,K);
            System.out.println(res);

        }
    }

//        6
//        -2 0 1 2 3 6
//        2
    public static int core(int[] nums,int K){
        int len = nums.length;
        if(len<3){
            return 0;
        }
        int count=0;
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                int left = j, right = len-1;
                while (left<right){
                    int temp = nums[i]+nums[left]+nums[right];
                    if(temp<K){
                        count++;
                    }
                    right--;
                }
            }
        }
        return count;
    }
}
