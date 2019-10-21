package com.interview.拼多多;

import java.util.*;

public class Main {

    static HashMap<Integer, Long> map;
    static int n;
    static int[] a;
    static double[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        p = new double[a[a.length - 1] + 1];
        int begin = 0;
        for (int max = 1; max <= a[a.length - 1]; max++) {
            while (a[begin] < max) {
                begin ++;
            }
            double p_max = 1.0;
            for (int i = begin; i < n; i++) {
                p_max *= max / (double)a[i];
            }
            p_max -= Arrays.stream(p).sum();
            p[max] = p_max;
        }
        double EX = 0;
        for (int X = 1; X <= a[a.length - 1]; X++) {
            EX += X * p[X];
        }
        System.out.printf("%.2f",EX);
    }
}
