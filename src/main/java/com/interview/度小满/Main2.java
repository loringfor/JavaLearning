package com.interview.度小满;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            String[] res = new String[len];
            for(int i=0;i<len;i++){
                int N = in.nextInt();
                long sum = 0;
                int count=0;
                for(int j=1;j<=N;j++){
                    for(int k=j+1;k<=N;k++){
                        if(judge(j,k)){
                            sum += j*k;
                        }
                        count++;
                    }
                }
                if(sum % count == 0){
                    res[i] = String.valueOf(sum/count);
                }else {
                    int temp = (int)gcd1(sum,count);
                    res[i] = String.valueOf(sum/temp)+"/"+String.valueOf(count/temp);
                }
            }

            for(int i=0;i<len;i++){
                System.out.println(res[i]);
            }
        }
    }

    public static boolean judge(long a,long b){
        if(a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        long c;
        while((c = a % b) != 0) {
            a = b;
            b = c;
        }
//        System.out.println(b == 1);//b == 1 表示互质
        return b==1;
    }

    public static int amountC( int a,int b) {
        int da=1;
        int xiao=1;
        //5！/(5-3)!
        for(int i=0;i<b;i++) {
            da=da*a;
            a--;
        }
        //3！
        for(;b>0;b--) {
            xiao=xiao*b;
        }
        return da/xiao;
    }

    public static long gcd1(long a, long b) {
        if(a < 0 || b < 0)
            return -1;
        if(a == b || a == 0)
            return b;
        if(b == 0)
            return a;
        if(a < b)
            return gcd1(a, b % a);
        else
            return gcd1(b, a % b);
    }






}
