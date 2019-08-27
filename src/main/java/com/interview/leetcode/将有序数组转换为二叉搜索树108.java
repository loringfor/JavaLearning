package com.interview.leetcode;

import com.interview.TreeNode;

public class 将有序数组转换为二叉搜索树108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length<1)
            return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(right<left){
            return null;
        }

        int middle = left+right >>1;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(nums,left,middle-1);
        root.right = sortedArrayToBST(nums,middle+1,right);
        return root;
    }
}
