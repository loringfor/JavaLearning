package com.interview;

/**
 * n 皇后问题
 * 在n×n格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 */
public class NQuene{
    private int num;
    private int[] array;
    int sum=0;
    public NQuene(int num) {
        this.num = num;
        array = new int[num];
    }
    public void backTack(int n){
        if(n==num){
            for(int i=0;i<num;i++){
                System.out.print("array["+ i +"]="+array[i] + ",");
            }
            System.out.println();
            sum++;
        }else {
            for(int i=0; i<num; i++){ // i表示列
                array[n]=i;
                if(isPlace(n)){ //如果第n行可以放，继续看n + 1行
                    backTack(n+1);
                }
            }
        }
    }
    boolean isPlace(int i){
        for (int j=0; j<i; j++){
            if(Math.abs(j-i)==Math.abs(array[j]-array[i]) || array[i]==array[j]){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int newX=0;
        while(x!=0){
            newX = newX*10+x%10;
            x /=10;
        }
        return x==newX;
    }
    public static void main(String[] args) {
        NQuene nQuene=new NQuene(4);
        nQuene.backTack(0);
        System.out.println(nQuene.sum);

//        System.out.println(isPalindrome(121));
    }

}