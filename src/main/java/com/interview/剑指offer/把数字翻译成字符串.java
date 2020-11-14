package com.interview.剑指offer;

public class 把数字翻译成字符串 {
    public static int getTranslationCount(String s) {
        int len=s.length();
        if(s==null || len<1)
            return 0;
        int[] dp = new int[len+1];
        dp[0]=1;
        dp[1]=1;
        String temp=null;
        for(int i=2; i<=len; i++){
            dp[i]=dp[i-1];
            temp=String.valueOf(s.charAt(i-2)) + String.valueOf(s.charAt(i-1));
            System.out.println(temp);
            int num = Integer.parseInt(temp);
            if(num>=0 && num<26)
                dp[i]+=dp[i-2];

        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount("12258"));
    }
}
