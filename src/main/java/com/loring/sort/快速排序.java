package com.loring.sort;

public class 快速排序 {

    public static void quickSort(int[] nums){
        QSort(nums,0,nums.length-1);
    }

    public static void QSort(int[] nums,int low,int high){
        int pivot;
        if(low<high){
            pivot = pivot(nums,low,high);
            QSort(nums,low,pivot-1);
            QSort(nums,pivot+1,high);
        }
    }

    public static int pivot(int[] nums,int low,int high){
        int pivotKey = nums[low];
        while(low<high){
            while(pivotKey<=nums[high] && low<high){
                high--;
            }
            swap(nums,low,high);
            while(pivotKey>=nums[low] && low<high){
                low++;
            }
            swap(nums,low,high);
        }
        return low;
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
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
