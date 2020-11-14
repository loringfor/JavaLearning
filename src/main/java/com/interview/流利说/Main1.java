package com.interview.流利说;

import java.util.*;

//3
//1 2
//13 19
//4 9
//10 20
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int[] c = new int[n];
            int[] d = new int[n];
            int[] e = new int[n];

            int sum=0;
            for(int i=0; i<n; i++){
                c[i]=in.nextInt();
                d[i]=in.nextInt();
                e[i]=d[i]-c[i];
                sum+=d[i];
            }

            Arrays.sort(e);

            for(int i=n-1;i>=n-a;i--){
                sum-=e[i];
            }
            System.out.println(sum);
        }
    }
}
