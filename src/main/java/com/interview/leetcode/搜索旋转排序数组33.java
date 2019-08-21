package com.interview.leetcode;

public class 搜索旋转排序数组33 {
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;

            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums ={1,3};
        System.out.println(search(nums,3));
    }

    public static int search(int[] nums, int target) {
        if(nums==null || nums.length<1){
            return -1;
        }
        int left = 0, right = nums.length-1;
        int middle;
        while(left < right){
            middle = (left + right) >> 1;
            if(target == nums[middle]){
                return middle;
            }
            if(rightVal(target, nums[0]) > rightVal(nums[middle], nums[0])){
                left = middle + 1;
            } else{
                right = middle;
            }
        }
        return target==nums[left]?left:-1;
    }

    public static int rightVal(int x, int start){
        return x < start ? x + 0x3F3F3F3F - start : x;
    }
}
