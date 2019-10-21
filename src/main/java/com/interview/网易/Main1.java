package com.interview.网易;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            String[] res = new String[len];
            for(int i=0;i<len;i++){
                nums[i] = in.nextInt();
                res[i] = core(nums[i]);
            }

            for(int i=0;i<len;i++){
                System.out.println(res[i]);
            }

        }
    }


    public static String core(int num){
        if(num<10){
            return String.valueOf(num);
        }else{
            int count = num / 9;
            int yushu = num % 9;
            StringBuilder builder = new StringBuilder();
            if(yushu!=0){
                builder.append(String.valueOf(yushu));
            }
            for(int i=0;i<count;i++){
                builder.append("9");
            }
            return builder.toString();
        }

    }

}
