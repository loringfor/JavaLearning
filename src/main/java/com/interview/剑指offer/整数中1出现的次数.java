package com.interview.剑指offer;

public class 整数中1出现的次数 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            count+=count(i);
        }
        return count;
    }

    public static int count(int num){
        int res=num;
        int count=0;
        while(res!=0){
            if(res%10==1)
                count++;
            res=res/10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(235));
    }
}
