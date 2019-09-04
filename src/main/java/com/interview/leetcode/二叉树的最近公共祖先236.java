package com.interview.leetcode;

import com.interview.TreeNode;

public class 二叉树的最近公共祖先236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }else{
            if(right==null){
                return left;
            }else{
                return root;
            }
        }
    }
}
