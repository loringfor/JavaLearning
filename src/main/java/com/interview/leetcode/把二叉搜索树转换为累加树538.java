package com.interview.leetcode;

import com.interview.TreeNode;

public class 把二叉搜索树转换为累加树538 {

    int pre=0;
    public TreeNode convertBST(TreeNode root) {
        travel(root);
        return root;
    }

    public void travel(TreeNode root){
        if(root==null) {
            return;
        }
        travel(root.right);
        root.val += pre;
        pre = root.val;
        travel(root.left);
    }

}
