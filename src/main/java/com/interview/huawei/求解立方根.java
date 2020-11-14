package com.interview.huawei;

import java.math.BigDecimal;
import java.util.*;

public class 求解立方根  {
    public static double getCubeRoot(double input){
        double x0=1;
        double x1=x0-func(x0,input)/binFunc(x0);
        while(Math.abs(x0-x1)>0.001){
            x0=x1;
            x1=x0-func(x0,input)/binFunc(x0);
        }
        return x0;
    }

    public static double func(double x,double num){
        return x*x*x-num;
    }

    public static double binFunc(double x){
        return 3*x*x;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            double num = in.nextDouble();
            double f = getCubeRoot(num);
            BigDecimal b = new BigDecimal(f);
            double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(f1);
        }
    }
}

