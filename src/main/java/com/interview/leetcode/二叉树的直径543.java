package com.interview.leetcode;

import com.interview.TreeNode;

public class 二叉树的直径543 {

    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        res = Math.max(res,left+right);
        return Math.max(left,right)+1;
    }
}
