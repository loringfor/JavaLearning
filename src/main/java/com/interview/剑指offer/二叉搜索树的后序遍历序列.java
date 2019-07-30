package com.interview.剑指offer;

public class 二叉搜索树的后序遍历序列 {
    public static boolean verifySequenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length<1)
            return true;
        return judge(sequence,0,sequence.length-1);
    }

    public static boolean judge(int[] sequence,int left,int right){
        if(right>=left)
            return true;
        int i;
        for(i=left;i<right;i++){
            if(sequence[i]>sequence[right])
                break;
        }

        for(int j=i;j<right;j++){
            System.out.println("---"+j+":"+sequence[j]);
            if(sequence[j]<sequence[right])
                return false;
        }

        return judge(sequence,left,i-1) && judge(sequence,i,right-1);
    }

    public static void main(String[] args) {
        int[] sequence ={1, 2, 5, 4, 9, 10, 7, 3, 6, 8};
        System.out.println(verifySequenceOfBST(sequence));
    }
}
