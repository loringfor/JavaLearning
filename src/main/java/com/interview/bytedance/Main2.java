package com.interview.bytedance;

import java.util.Scanner;

public class Main2 {
//    3
//    1 3
//    2 3
//    3 3
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            long[][] nums = new long[N][2];
            for(int i=0;i<N;i++){
                nums[i][0] = in.nextLong();
                nums[i][1] = in.nextLong();
            }

            long queue=0, end =0;
            for(int i=0;i<N;i++){
                long t = nums[i][0];
                long c = nums[i][1];
                if(t>=end){
                    end = t+c;
                    queue = Math.max(queue,c);
                }else{
                    end = end  + c;
                    queue = Math.max(queue,end-t);
                }
            }
            System.out.println(end+" "+queue);
        }
    }

}
