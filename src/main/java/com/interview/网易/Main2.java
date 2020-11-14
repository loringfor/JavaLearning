package com.interview.网易;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] res = new int[n];

            for(int i=0;i<n;i++){
                int A = in.nextInt();
                int B = in.nextInt();
                int p = in.nextInt();
                int q = in.nextInt();
                int count = 0;
                while (true){
                    if(A+p>=B){
                        count++;
                        break;
                    }
                    if(2*p>p*q){
                        count+=2;
                        A += 2*p;
                    }else{
                        count+=2;
                        p = p*q;
                        A += p;
                    }
                    if(A>=B)
                        break;
                }
                res[i] = count;
            }

            for(int i=0;i<n;i++){
                System.out.println(res[i]);
            }
        }
    }


}
