package com.interview.云从科技;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String nums1 = in.next();
            String nums2 = in.next();
            nums1 = nums1.substring(1,nums1.length()-1);
            nums2 = nums2.substring(1,nums2.length()-1);
            String[] strs1 = nums1.split(",");
            String[] strs2 = nums2.split(",");
            int[] num1 = new int[strs1.length];
            int[] num2 = new int[strs2.length];
            for(int i=0;i<strs1.length;i++){
                num1[i] = Integer.parseInt(strs1[i]);
            }
            for(int i=0;i<strs2.length;i++){
                num2[i] = Integer.parseInt(strs2[i]);
            }

            List<Integer> list = new ArrayList<>();
            for(int i=0;i<num1.length;i++){
                for(int j=0;j<num2.length;j++){
                    if(num1[i]==num2[j]){
                        if(!list.contains(num1[i]))
                            list.add(num1[i]);
                        break;
                    }
                }
            }
            Collections.sort(list);
            StringBuilder res = new StringBuilder("[");
            for(int j=0;j<list.size();j++){
                res.append(list.get(j)+",");
            }
            String ans = res.substring(0,res.length()-1);
            System.out.println(ans+"]");
        }
    }
}
