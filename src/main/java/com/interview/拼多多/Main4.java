package com.interview.拼多多;

import java.util.*;

public class Main4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            // 5
            int N = in.nextInt();
            boolean[] flag = new boolean[N];
            // 4
            int M = in.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i=0;i<M;i++){
                int[] temp = {in.nextInt(),in.nextInt()};
                list.add(temp);
            }

            if(M==0){
                System.out.println(N);
            }else{

            }


        }
    }
}
