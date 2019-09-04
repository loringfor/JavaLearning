package com.loring;

public class Test{
    public static void main(String[] args) {
//        int[] list = {3,2,3,4,1};
//        sort(list);
//        for(int i=0;i<list.length;i++){
//            System.out.print(list[i]+" ");
//        }
//        int[] nums={2,6,4,8,10,9,15};
//        findUnsortedSubarray(nums);

        int[] nums;
        nums=new int[4];
        for(int i:nums){
            System.out.println(i);
        }
    }


    public static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength+1][pLength+1];
        //都为空
        dp[0][0]=true;
        //s为空
        for(int i=1; i<=pLength; i++){
            if(p.charAt(i-1)=='*')
                dp[0][i] = dp[0][i-1];
        }
        //s,p都不为空
        for(int i=1; i<=sLength; i++){
            for(int j=1; j<pLength; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j] || dp[i-1][j-1];
                }
            }
        }
        return dp[sLength][pLength];
    }

    public static void sort(int[] list){
        QSort(list,0,list.length-1);
    }

    public static void QSort(int[] list,int low,int high){
        int parition;
        if(low<high){
            parition = parition(list,low,high);
            QSort(list,low,parition-1);
            QSort(list,parition+1,high);
        }
    }

    public static int parition(int[] list,int low,int high){
        int priotKey=list[low];
        while(low<high){
            while(low<high && priotKey<=list[high])
                high--;
            swap(list,low,high);
            while(low<high && priotKey>=list[low])
                low++;
            swap(list,low,high);
        }
        return low;
    }

    public static void swap(int[] list,int i,int j){
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }
}