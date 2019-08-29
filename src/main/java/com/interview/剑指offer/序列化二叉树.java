package com.interview.剑指offer;

import com.interview.TreeNode;
import java.util.*;

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
        System.out.println("原始树："+root.toString());
        String result = serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode  deserializeRoot = deserialize(result);
        System.out.println("反序列后的树："+deserializeRoot);
        System.out.println("层次序列化结果："+Serialize(root));
    }

//    static String Serialize(TreeNode root) {
//        StringBuilder builder=new StringBuilder();
//        Queue<TreeNode> queue =new LinkedList<TreeNode>();
//        if(root!=null){
//            queue.add(root);
//        }
//        while(!queue.isEmpty()){
//            TreeNode node=queue.poll();
//            if(node!=null){
//                queue.offer(node.left);
//                queue.offer(node.right);
//                builder.append(node.val+",");
//            }else{
//                builder.append("#"+",");
//            }
//        }
//        if(builder.length()!=0){
//            builder.deleteCharAt(builder.length()-1);
//        }
//        return builder.toString();
//
//    }

    //层序遍历
    public static String Serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue =new LinkedList<TreeNode>();
        int count = (1 << treeDepth(root)) - 1;//计数，拿到此树的深度后计算对应完全二叉树节点数
        queue.add(root);
        count--;
        TreeNode tmpNode = null;

        //层次遍历二叉树，开始序列化
        while(queue.size() > 0 && count >= 0){
            tmpNode = queue.poll();
            if(tmpNode != null){
                sb.append(tmpNode.val+",");
                queue.add(tmpNode.left);
                queue.add(tmpNode.right);
            }else{
                sb.append("#,");// #作为空节点占位符
                queue.add(null);
                queue.add(null);
            }
            count --;
        }
        return sb.toString();
    }

    public static TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        return Deserialize(str.split(","), 0);
    }

    public static TreeNode Deserialize(String[] strings, int index){
        TreeNode newNode = null;
        if(index < strings.length){
            if(!strings[index].equals("#")){
                newNode = new TreeNode(Integer.parseInt(strings[index]));
                newNode.left = Deserialize(strings, 2 * index + 1);
                newNode.right = Deserialize(strings, 2 * index + 2);
            }
        }
        return newNode;
    }

    public static int treeDepth(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }else{
            int lDepth = treeDepth(root.left) + 1;
            int rDepth = treeDepth(root.right) + 1;
            return lDepth > rDepth ? lDepth : rDepth;
        }
    }

}

