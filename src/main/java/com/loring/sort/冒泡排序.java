package com.loring.sort;

public class 冒泡排序 {
    public static void bubleSort(int[] nums){
        boolean flag = true;
        for(int i=0;i<nums.length && flag;i++){
            flag = false;
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                    flag = true;
                }
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        if(i==j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums={5,8,9,8,2,1};
        bubleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
