package com.interview.剑指offer;

import com.interview.TreeNode;
import java.util.*;

// 与leetcode437题路径总和有区别
public class 二叉树中和为某一值的路径 {

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if(target==0 && root.left==null && root.right==null){
            listAll.add(new ArrayList(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        // 移除最后一个
        list.remove(list.size()-1);
        return listAll;
    }
}
