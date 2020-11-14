package com.interview.快手;

import java.util.*;

public class Main3 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int len = in.nextInt();
//            int[] nums = new int[len];
//            int sum =0;
//            for(int i=0;i<len;i++){
//                nums[i] = in.nextInt();
//                sum+=nums[i];
//            }
//            if(sum % 2 == 0){
//                System.out.println(0);
//            }else{
//                int target = sum >> 1;
//                Arrays.sort(nums);
//                int num=0;
//                for(int i=0;i<len;i++){
//                    if(num>=target){
//                        break;
//                    }else {
//                        num+=nums[i];
//                    }
//                }
//                int res = Math.abs(num-(sum-num));
//                System.out.println(res);
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int i=0;i<len;i++){
                nums[i] = in.nextInt();
            }

            Arrays.sort(nums);
            int num = 0;
            for(int i=nums.length-1;i>=0;i--){
                if(num>=0){
                    num -= nums[i];
                }else{
                    num += nums[i];
                }
            }
            System.out.println(Math.abs(num));
        }
    }
}
