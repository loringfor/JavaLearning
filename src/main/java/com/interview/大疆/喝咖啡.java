package com.interview.大疆;

import java.util.*;

public class 喝咖啡{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int A = in.nextInt(); //效率
            int X = in.nextInt(); //次数
            int[] bug = new int[N];

            for(int i =0;i<N;i++){
                bug[i] = in.nextInt();
            }
            // 8 2 8
            // 60 60 60 60 60 60 60 60
            // 240
            int bugTime=0;
            for(int i=0;i<N;i++)
                bugTime+=bug[i];

            int sumTime =X*60*A + 60*(8-X);
            int coffeeTime = X*60*A;
            if(bugTime>sumTime)
                System.out.println(0);
            else{
                if(bugTime<=coffeeTime){
                    if(bugTime%A!=0)
                        System.out.println(bugTime/A+1);
                    else
                        System.out.println(bugTime/A);
                }else {
                    int temp=bugTime - coffeeTime;
                    System.out.println(temp+coffeeTime/A);
                }
            }
        }

        in.close();
    }
}