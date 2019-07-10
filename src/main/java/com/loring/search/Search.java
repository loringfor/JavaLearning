package com.loring.search;

public class Search {
    public static void main(String[] args) {
        int list[] = { 18, 20, 30, 46, 50, 51, 65, 77, 82, 97 };
        System.out.println(binarySearch(list,18));
    }

    public static int binarySearch(int[] list,int num){
        int low=0;
        int high=list.length-1;
        int middle;
        while (low <= high){
            middle=(low+high)/2;
            System.out.println("low:"+low+",middle:"+middle+",high:"+high);
            if(num < list[middle])
                high = middle-1;
            else if(num > list[middle])
                low = middle+1;
            else
                return middle+1;
        }
        return 0;
    }
}
