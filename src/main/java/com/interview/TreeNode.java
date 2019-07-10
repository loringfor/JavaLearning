package com.interview;

import java.util.*;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Main{
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums,8);
        System.out.println(res[0]);

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        List<Integer> list = 无向无环图直径.inorderTraversalNonCur(root);
//        for(int i=0;i<list.size();i++){
//            System.out.print(list.get(i)+" ");
//        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int left=0;
        int right=nums.length-1;
        int middle,m,n;
        while(left<=right){
            middle=(left+right)/2;
            if(nums[middle]==target){
                m=middle;
                n=middle;
                while(nums[m]==target && m>-1)
                    m--;
                while(nums[n]==target && n<nums.length)
                    n++;
                res[0]=m;
                res[1]=n;
            }else if(nums[middle]<target){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return res;
    }

    // 非递归中序遍历
    public static List<Integer> inorderTraversalNonCur(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            while (temp.left!=null){
                stack.push(temp.left);
                temp = temp.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return list;
    }

    public static void search(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.val);
        search(root.left);
        search(root.right);
    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<>();
        Stack<TreeNode> treeStack=new Stack<>();
        if(root==null) //如果为空树则返回
            return resultList;
        treeStack.push(root);
        while(!treeStack.isEmpty()){
            TreeNode tempNode=treeStack.pop();
            if(tempNode!=null){
                resultList.add(tempNode.val);//访问根节点
                treeStack.push(tempNode.right); //入栈右孩子
                treeStack.push(tempNode.left);//入栈左孩子
            }
        }
        return resultList;
    }

    //中序遍历
//    public List<Integer> inorderTraversalNonCur(TreeNode root) {
//        List<Integer> visitedList=new ArrayList<>();
//        Map<TreeNode,Integer> visitedNodeMap=new HashMap<>();//保存已访问的节点
//        Stack<TreeNode> toBeVisitedNodes=new Stack<>();//待访问的节点
//        if(root==null)
//            return visitedList;
//        toBeVisitedNodes.push(root);
//        while(!toBeVisitedNodes.isEmpty()){
//            //注意这里是peek而不是pop
//            TreeNode tempNode=toBeVisitedNodes.peek();
//            //如果该节点的左节点还未被访问，则需先访问其左节点
//            while(tempNode.left!=null){
//                //该节点已经被访问（不存在某个节点已被访问但其左节点还未被访问的情况）
//                if(visitedNodeMap.get(tempNode.left)!=null)
//                    break;
//                toBeVisitedNodes.push(tempNode.left);
//                tempNode=tempNode.left;
//            }
//            tempNode=toBeVisitedNodes.pop();//访问节点
//            visitedList.add(tempNode.val);
//            visitedNodeMap.put(tempNode, 1);//将节点加入已访问map
//            if(tempNode.right!=null) //将右结点入栈
//                toBeVisitedNodes.push(tempNode.right);
//        }

//        return visitedList;

//    }
    //后序遍历

    public List<Integer> postOrderNonCur(TreeNode root){
        List<Integer> resultList=new ArrayList<>();
        if(root==null)
            return resultList;
        Map<TreeNode,Integer> visitedMap=new HashMap<>();
        Stack<TreeNode> toBeVisitedStack=new Stack<>();
        toBeVisitedStack.push(root);
        while(!toBeVisitedStack.isEmpty()){
            TreeNode tempNode=toBeVisitedStack.peek(); //注意这里是peek而不是pop
            if(tempNode.left==null && tempNode.right==null){ //如果没有左右孩子则访问
                resultList.add(tempNode.val);
                visitedMap.put(tempNode, 1);
                toBeVisitedStack.pop();
                continue;
            }else if(!((tempNode.left!=null&&visitedMap.get(tempNode.left)==null )
                    || (tempNode.right!=null && visitedMap.get(tempNode.right)==null))){
                //如果节点的左右孩子均已被访问
                resultList.add(tempNode.val);
                toBeVisitedStack.pop();
                visitedMap.put(tempNode, 1);
                continue;
            }
            if(tempNode.left!=null){
                //左孩子没有被访问
                while(tempNode.left!=null && visitedMap.get(tempNode.left)==null){
                    toBeVisitedStack.push(tempNode.left);
                    tempNode=tempNode.left;
                }
            }
            if(tempNode.right!=null){
                if(visitedMap.get(tempNode.right)==null){//右孩子没有被访问
                    toBeVisitedStack.push(tempNode.right);
                }
            }
        }
        return resultList;
    }
}