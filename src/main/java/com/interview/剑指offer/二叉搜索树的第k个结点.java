package com.interview.剑指offer;

import com.interview.TreeNode;

public class 二叉搜索树的第k个结点 {
    static TreeNode res=null;
    public static TreeNode kthNode(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    public static void dfs(TreeNode root,int k){
        if(root==null)
            return;
        dfs(root.left,k);
        k--;
        if(k==0)
            res=root;
        dfs(root.right,k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode temp = kthNode(root,3);
        System.out.println(temp.val);
    }
}

