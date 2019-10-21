package com.interview.剑指offer;

public class 整数中1出现的次数 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        int i=1;
        int before,current,after;
        while(n/i!=0){
            before = n/(i*10);
            current = (n/i)%10;
            after = n-n/i*i;
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if(current==0){
                count+=before*i;
            }else if(current==1){  //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count+=before*i+after+1;
            }else{ //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
                count+=(before+1)*i;
            }
            i*=10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(235));
    }
}
