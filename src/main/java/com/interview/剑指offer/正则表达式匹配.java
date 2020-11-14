package com.interview.剑指offer;

public class 正则表达式匹配 {
    
    public boolean match(char[] str, char[] pattern){
        int sLen = str.length;
        int pLen = pattern.length;
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for(int i=1;i<=pLen;i++){
            if(pattern[i-1]=='*' && i>1)
                dp[0][i]=dp[0][i-2];
            else if(pattern[i-1]=='*' && i<2)
                dp[0][i]=dp[0][i-1];
        }

        for(int i=1;i<=sLen;i++){
            for(int j=1;j<=pLen;j++){
                if(pattern[j-1]==str[i-1] || pattern[j-1]=='.')
                    dp[i][j]=dp[i-1][j-1];
                if(pattern[j-1]=='*'){
                    if(pattern[j-2]!=str[i-1])
                        dp[i][j]=dp[i][j-2];
                    if(pattern[j-2]==str[i-1]||pattern[j-2]=='.')
                        dp[i][j]= dp[i][j-2]||dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[sLen][pLen];
    }
}
