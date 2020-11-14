package com.interview;

import java.util.*;

public class 层序遍历 {


//    计算二叉树的高度
//  逐层打印：
//    例如打印二叉树的第k层，可以看作以root->_left为根节点，
//    打印它的k-1层，然后以root->_right为根节点，打印它的k-1层，直到k==1。
    public static void levelOrder(TreeNode root){
        if(root==null){
            return;
        }
        int depth = depth(root);
        for(int i=0;i<=depth;i++){
            levelOrder(root,i);
        }
    }
    public static void levelOrder(TreeNode root,int level){
        if (root==null || level==0){
            return;
        }
        if(level==1){
            System.out.print(root.val+" ");
        }
        levelOrder(root.left,level-1);
        levelOrder(root.right,level-1);
    }

    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
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
//        levelOrder(root);
    }

    public static List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.peek();
            if(temp.right==last || temp.right==null){
                last = temp;
                res.add(stack.pop().val);
            }else{
                root = temp.right;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
        return res;
    }


}
