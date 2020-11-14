package com.interview.leetcode;

public class 乘法表中第K小的数668 {

    public static int findKthNumber(int m, int n, int k) {
        int low=1, high=m*n;
        while (low<high){
            int middle = low+high  >>1;
            int count = smallNumCount(middle,m,n);
            if(count<k){
                low = middle+1;
            }else {
                high = middle;
            }
        }
        return low;
    }

    public static int smallNumCount(int num,int m,int n){
        int count=0;
        for(int i=1;i<=m;i++){
            count+=Math.min(num/i,n);
        }
        return count;
    }
}
