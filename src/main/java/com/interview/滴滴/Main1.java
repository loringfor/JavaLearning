package com.interview.滴滴;

import java.util.*;

public class Main1 {
//    1、先转换负数
//    2、扫描，如果有连续乘法，排序，连续除法，排序
//    3、连续加法，连续减法，要看下后面有没有带乘除法，也是排序

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int len = in.nextInt();
            String str = in.nextLine();
            String[] strs = str.split("\\s+");
            int[] nums = new int[len];
            int j=0;
            for(int i=0;i<strs.length;i=+2){
                int temp = Integer.parseInt(strs[i]);
                if(temp<0){
                    if(i-1>=0){
                        if(strs[i-1].equals("-")){
                            strs[i-1]="+";
                        }else if(strs[i-1].equals("+")){
                            strs[i-1]="-";
                        }
                    }
                    nums[j++]=-temp;
                }
                nums[j++]=temp;
            }

            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
        }
    }
}
