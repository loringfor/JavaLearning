package com.interview.剑指offer;

public class 圆圈中最后剩下的数 {

        public static int LastRemaining_Solution(int n, int m) {
            if(n<1 || m<1)
                return -1;
            boolean[] array = new boolean[n];
            int count=n;
            int i=-1;
            int step=0;
            while(n>0){
                i++;
                if(i>=n)
                    i=0;
                if(array[i]==true){
                    continue;
                }
                step++;
                if(step==m){
                    step=0;
                    n--;
                    array[i]=true;
                    //continue;
                }

            }
            return i;
        }

    public static void main(String[] args) {
        LastRemaining_Solution(5,3);
    }

}
