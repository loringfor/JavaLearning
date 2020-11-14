package com.interview.剑指offer;

public class 数字序列中某一位的数字 {
    public static int digitAtIndex(int n) {
        long i=1, s=9, base=1;
        while(n >= (i* s)){
            n -=  i* s;
            i++;
            s *= 10;
            base *= 10;
        }
        int mod =(int) (n % i);
        long num = base + n / i -1;
        if(mod==0){
            return (int)(num % 10);
        }else{
            num++;
            for(int j=0;j < i-mod;j++)
                num = num/10;
            return (int)num%10;
        }
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(2147483647));
    }
}
