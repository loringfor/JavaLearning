package com.loring.sort;

public class Sort {
    public static void main(String[] args) {

        int[] list={5,8,9,8,2,1};
        mergeSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
    }

    public static void mergeSort(int[] list){
        MSort(list,0,list.length-1);
    }
    public static void MSort(int[] list,int left,int right){
        if(left<right){
            int middle=(left+right)/2;
            MSort(list,left,middle);
            MSort(list,middle+1,right);
            merge(list,left,middle,right);
        }
    }

    public static void merge(int[] list,int left,int middle,int right){
        int[] temp=new int[right-left+1];
        int i=left;
        int j=middle+1;
        int k=0;
        while(i<=middle && j<=right){
            if(list[i]<=list[j])
                temp[k++]=list[i++];
            else
                temp[k++]=list[j++];
        }
        while(i<=middle){
            temp[k++]=list[i++];
        }
        while (j<=right){
            temp[k++]=list[j++];
        }
        for(int m=0; m<temp.length; m++){
            list[m+left]=temp[m];
        }
    }

    public static void swap(int[] list,int i,int j){
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }

    public static void quickSort(int[] list){
        QSort(list,0,list.length-1);
    }

    public static void QSort(int[] list,int low,int high){
        int pivot;
        if(low<high){
            pivot = partion(list,low,high);
            QSort(list,0,pivot-1);
            QSort(list,pivot+1,high);
        }
    }

    public static int partion(int[] list,int low,int high){
        int pivotKey=list[low];
        while(low<high){
            while(pivotKey<=list[high] && low<high)
                high--;
            swap(list,low,high);
            while(pivotKey>=list[low] && low<high)
                low++;
            swap(list,low,high);
        }
        return low;
    }
}
