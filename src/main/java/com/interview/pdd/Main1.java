package com.interview.pdd;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int[] nums = new int[N];
            for(int i=0;i<N;i++){
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            long res = 0;
            if(M==1){
                res = nums[0]*nums[1];
            }else{
                int left=0,right=N-1;
                for(int i=0;i<M;i++){
                    res+= nums[left]*nums[right];
                    left++;
                    right--;
                }
            }
            System.out.println(res);
        }
    }
}
