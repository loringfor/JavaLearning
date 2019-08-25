package com.interview.leetcode;

import java.util.*;

public class 单词拆分139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict==null || wordDict.size()<1)
            return s.isEmpty();
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i=1;i<=len;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }
}
