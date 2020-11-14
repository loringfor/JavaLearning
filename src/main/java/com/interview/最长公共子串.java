package com.interview;

public class 最长公共子串 {
    // 暴力求解
    public static String LCS(String str1,String str2){
        int lcs=0;
        int left=0,right=0;
        for(int i=0;i<str1.length();i++){
            for(int j=i+1;j<=str1.length();j++){
                String temp = str1.substring(i,j);
                int index = str2.indexOf(temp);
                if(index!=-1){
                    lcs = Math.max(lcs,j-i);
                    if(lcs==j-i){
                        left=i;
                        right=j;
                    }
                }
            }
        }
        return str1.substring(left,right);
    }

    /**
     * 动态规划
     * 状态转移方程：
     * str1[i]==str2[j],dp[i][j]=dp[i-1][j-1]+1;
     * str1[i]!=str2[j]则dp[i][j]=0;
     *
     * 要记得对第一行和第一列进行初始化
     */
    public static String longestCommonSubString(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];
        int count=0;
        int end=0;
        for(int i=0;i<len1;i++){
            if(str1.charAt(i)==str2.charAt(0)){
                dp[i][0]=1;
            }
        }
        for(int i=0;i<len2;i++){
            if(str2.charAt(i)==str1.charAt(0)){
                dp[0][i]=1;
            }
        }

        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    count = Math.max(count,dp[i][j]);
                    if(count==dp[i][j]){
                        end = i;
                    }
                }else {
                    dp[i][j]=0;
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return str1.substring(end-count+1,end+1);
    }

    /**
     * 动态规划优化
     * 计算每一个dp[i][j]的时候只需要计算dp[i-1][j-1],
     * 按照斜线方向计算所有的值，只需要一个变量就可以计算
     * 按照斜方向计算，如(0，0)->(1，1),当然在遍历的时候应该从右上角到左下角
     */
    public static String longestCommonSubString1(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int max=0;
        int end=0;
        int row=0, col=len2-1;
        while (row<len1){
            int i=row;
            int j=col;
            int count=0;
            while(i<len1 && j<len2){
                if(str1.charAt(i)==str2.charAt(j)){
                    count++;
                    max = Math.max(max,count);
                    if(max==count){
                        end = i;
                    }
                }else {
                    count=0;
                }
                i++;
                j++;
            }
            if(col>0){
                col--;
            }else {
                row++;
            }
        }
        return str1.substring(end-max+1,end+1);
    }

    public static void main(String[] args) {
        String str1 = "1B234567C", str2="1234567E";
//        String str1 = "aabb", str2="bbaa";
        System.out.println(longestCommonSubString1(str1,str2));
    }
}
