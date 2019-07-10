package com.interview.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 全排列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] string = in.nextLine().split("\\s+");
//        int[] array = new int[string.length];
        StringBuilder str = new StringBuilder();
        for(int i=0;i<string.length;i++){
            str.append(string[i]);
        }
//        System.out.println(str);

        ArrayList<String> list = Permutation(str.toString());
        for(int i=0;i<list.size();i++){
            System.out.print(Integer.parseInt(list.get(i))+" ");
        }

    }
    public static ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        ArrayList<String> list = new ArrayList();
        backtrack(list,array,0);
        Collections.sort(list);
        return list;
    }

    public static void backtrack(List<String> list,char[] array,int cursor){
        if(cursor==array.length-1){
            String temp = new String(array);
            if(!list.contains(temp))
                list.add(new String(array));
            return;
        }
        for(int i=cursor;i<array.length;i++){
            swap(array,i,cursor);
            backtrack(list,array,cursor+1);
            swap(array,i,cursor);
        }
    }

    public static void swap(char[] array,int i,int j){
        char temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
