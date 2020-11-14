package com.interview.leetcode;

public class 接雨水42 {

//    1. 找出最高点
//    2. 分别从两边往最高点遍历：如果当前数比左/右局部最大值小，说明可以接到水
    public int trap(int[] height) {
        int maxIndex=-1,max=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>max){
                maxIndex = i;
                max = height[i];
            }
        }

        int sum=0;
        int leftMax=0,rightMax=0;
        for(int i=0;i<maxIndex;i++){
            if(leftMax>height[i]){
                sum+=leftMax-height[i];
            }else{
                leftMax=height[i];
            }
        }

        for(int i=height.length-1;i>maxIndex;i--){
            if(rightMax>height[i]){
                sum+=rightMax-height[i];
            }else{
                rightMax=height[i];
            }
        }

        return sum;
    }

}
