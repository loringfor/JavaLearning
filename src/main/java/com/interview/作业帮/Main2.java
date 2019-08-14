package com.interview.作业帮;

import java.util.Scanner;

public class Main2 {
    public static String core(String str){
        char[] chars = str.toCharArray();
        int left=0, right=chars.length-1;
        while(left<right){
            char temp = chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] strs = str.split("\\s+");
            StringBuilder res = new StringBuilder();
            for(int i=strs.length-1;i>=0;i--){
                res.append(core(strs[i])+" ");
            }

            System.out.println(res.toString().trim());
        }
    }
}

