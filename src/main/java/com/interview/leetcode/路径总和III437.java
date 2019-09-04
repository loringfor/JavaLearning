package com.interview.leetcode;

import com.interview.TreeNode;

// 二叉树中找出路径和等于给定数值的路径总数
public class 路径总和III437 {

    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;

        return countPath(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int countPath(TreeNode root,int sum){
        if(root==null)
            return 0;
        int res=0;
        if(sum==root.val){
            res++;
        }
        res+=countPath(root.left,sum-root.val);
        res+=countPath(root.right,sum-root.val);
        return res;
    }
}
