package com.interview.拼多多;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }

            double result=0;
            for(int i=1; i<=50; i++){
                List<Integer> list = new ArrayList<>();
                int sum=1;
                for(int j=0;j<n;j++){
                    if(nums[j]>=i){
                        list.add(nums[j]);
                        sum*=nums[j];
                    }
                }
                int len = list.size();
                double res=0;
                if(i==1){
                    result +=(double) 1/(double)sum;
                    continue;
                }

                for(int k=1;k<=list.size();k++){
                    double pre = core(len)/core(k)*core(len-k) ;
                    double after= Math.pow(i-1, len-k)/(double) sum;
                    res += pre*after;
                }
                result += res*i;
            }

            String str = String.format("%.2f",result);
            System.out.println(str);

        }
    }

    public static double core(int num){
        int sum=1;
        for(int i=num;i>=1;i--){
            sum*=i;
        }
        return sum;
    }
}
