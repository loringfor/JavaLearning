package com.interview.剑指offer;

public class 旋转数组的最小数字 {
    public static int minNumberInRotateArray(int [] array) {
        if(array==null || array.length<1)
            return -1;
        int left=0,right=array.length-1;
        int middle;
        while(left<right){
            middle = left+right >>1;
            if(array[middle]>=array[left]){
                left=middle;
            }else{
                right=middle;
            }
            if(right-left==1)
                return Math.min(array[left],array[right]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={1};
        System.out.println(minNumberInRotateArray(nums));
    }
}
