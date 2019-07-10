package com.loring.base;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=null;
        while(scanner.hasNext())
            str=scanner.nextLine();
        System.out.println("String is: "+ str);
//        String[] strs=str.split("\\s+");
//        int[] nums=new int[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//            nums[i]=Integer.parseInt(strs[i]);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }
}
