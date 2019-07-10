package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}

public class Solution {
    // 非递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();
        if (root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            while (temp.left != null) {
                stack.push(temp.left);
                temp = temp.left;
            }
            TreeNode temp1 = stack.pop();
            list.add(temp1.val);
            if (temp1.right != null)
                stack.push(temp1.right);
        }
        return list;
    }
}

