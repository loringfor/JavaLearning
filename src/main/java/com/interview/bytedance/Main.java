package com.interview.bytedance;

import java.util.*;

public class Main {
    public static int sqrtNum(int num){
        int[] dp = new int[num+1];
        for(int i=2; i<=num; i++){
            //如果能开方
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i){
                dp[i] = dp[sqrt]+1;
            }else{
                dp[i]=dp[i-1]+1;
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
        return dp[num];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("输出为："+sqrtNum(num));

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(17,20);
        Iterator<Map.Entry<Integer,Integer>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()){
            Map.Entry<Integer,Integer> entry = iterable.next();
            System.out.print("key: "+entry.getKey());
            System.out.print(",value: "+entry.getValue());
            System.out.println();
        }

    }
}
