package com.interview.回溯法;

public class N皇后 {
    private int num;
    private int[] array;
    private int sum;

    public N皇后(int num) {
        this.num = num;
        array = new int[num];
    }

    public void backTrack(int n){
        if(n==array.length){
            sum++;
            for(int i=0;i<num;i++){
                System.out.print("array["+ i +"]="+array[i] + ",");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<num;i++){
            array[n]=i;
            if(isPlace(n)){
                backTrack(n+1);
            }
        }
    }

    public boolean isPlace(int n){
        for(int j=0;j<n;j++){
            if(array[n]==array[j]|| Math.abs(array[n]-array[j]) == Math.abs(n-j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        N皇后 nQueue = new N皇后(4);
        nQueue.backTrack(0);
        System.out.println(nQueue.sum);
    }
}
