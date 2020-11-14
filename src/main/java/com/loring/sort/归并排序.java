package com.loring.sort;

public class 归并排序 {

    public static void mergeSort(int[] nums){
        MSort(nums,0,nums.length-1);
    }

    public static void MSort(int[] nums,int low,int high){
        if(low<high){
            int middle = low+high >>1;
            MSort(nums,low,middle);
            MSort(nums,middle+1,high);
            merge(nums,low,middle,high);
        }
    }

    public static void merge(int[] nums,int low,int middle,int high){
        int[] temp = new int[high-low+1];
        int i=low,j=middle+1;
        int index=0;
        while(i<=middle && j<=high){
            if(nums[i]<=nums[j])
                temp[index++] = nums[i++];
            else
                temp[index++] = nums[j++];
        }

        while (i<=middle){
            temp[index++] = nums[i++];
        }

        while (j<=high){
            temp[index++] = nums[j++];
        }

        for(int k=0;k<temp.length;k++){
            nums[k+low] = temp[k];
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
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
