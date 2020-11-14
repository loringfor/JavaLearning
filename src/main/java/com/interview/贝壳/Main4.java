package com.interview.贝壳;

import java.util.*;

public class Main4 {

    public static int core(int[] nums){
        int len = nums.length;

        int[] left = new int[len];
        int[] right= new int[len];
        int[] leftNum=new int[len];
        int[] rightNum=new int[len];
        int[] leftRes=new int[len];
        int[] rightRes=new int[len];

        leftNum[0]=nums[0];
        rightNum[len-1]=nums[len-1];
        for (int i=1;i<len;i++) {
            if (nums[i] <= leftNum[i - 1]) {
                left[i] = leftNum[i - 1] + 1 - nums[i];
                leftNum[i]=leftNum[i - 1] + 1;
            }else{
                leftNum[i]=nums[i];
            }
            leftRes[i]=leftRes[i-1] + left[i];
        }

        for (int j=len-1;j>0;j--){
            if (rightNum[j]>=nums[j-1]){
                right[j-1]=rightNum[j] + 1 - nums[j-1];
                rightNum[j-1]=rightNum[j]+1;
            }else{
                rightNum[j-1]=nums[j-1];
            }
            rightRes[j-1]=rightRes[j]+right[j-1];
        }

        int sum=Math.min(leftRes[len-1],rightRes[0]);
        for (int i=1;i<len-1;i++){
            int temp=leftNum[i]>rightNum[i]? right[i]:left[i];
            sum=Math.min(sum,leftRes[i]+rightRes[i]-temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len=in.nextInt();
            int[] nums= new int[len];
            for (int i=0;i<len;i++){
                nums[i]=in.nextInt();
            }
            int res = core(nums);
            System.out.println(res);
        }
        
    }
}


