package com.interview.剑指offer;

import com.interview.TreeNode;

public class 判断是否平衡二叉树 {
    public static boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    private static int getDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left==-1){
            return -1;
        }
        int right = getDepth(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)>1 ? -1 : Math.max(left,right)+1;
    }
}
