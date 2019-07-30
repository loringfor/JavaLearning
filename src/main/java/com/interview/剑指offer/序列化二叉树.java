package com.interview.剑指offer;

import com.interview.TreeNode;

public class 序列化二叉树 {

    //前序遍历
    public static String serialize(TreeNode root){
        if(root==null){
            return "#,";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val+",");
        stringBuilder.append(serialize(root.left));
        stringBuilder.append(serialize(root.right));
        return stringBuilder.toString();
    }

    static int cur=-1;
    static TreeNode deserialize(String str) {
        String[] strs=str.split(",");
        return dfs(strs);
    }

    static TreeNode dfs(String[] strs){
        cur++;
        if(cur>=strs.length-1)
            return null;
        if("#".equals(strs[cur]))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[cur]));
        root.left=dfs(strs);
        root.right=dfs(strs);
        return root;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode root = new TreeNode (1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("原始树："+root.toString());
        String result = serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode  deserializeRoot = deserialize(result);
        System.out.println("反序列后的树："+deserializeRoot);
    }
}

