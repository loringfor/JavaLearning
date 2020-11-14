package com.interview.二叉树;

import com.interview.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树后序遍历 {
    public static List<Integer> postOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.peek();
            if(temp.right==null || temp.right ==last){
                list.add(temp.val);
                last = temp;
                stack.pop();
            }else{
                root = temp.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //                  \
        //                   7
        //    1,2,4,#,#,#,3,5,#,#,6,#,7,#,#,
        TreeNode root = new TreeNode (1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        List<Integer> list = postOrder(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
