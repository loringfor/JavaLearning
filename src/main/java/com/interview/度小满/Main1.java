package com.interview.度小满;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int res = 0;
            for(int i=1;i<=n-a+1;i++){
                for(int j=1;j<=m-b+1;j++){
                    int max=0;
                    for(int p=i;p<i+m;p++){
                        for(int q=j;q<j+n;q++){
                            max = Math.max(max,(p*q)%10);
                        }
                    }
                    res+=max;
                }
            }
            System.out.println(res);
        }
    }

}
