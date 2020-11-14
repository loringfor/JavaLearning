package com.interview.huawei;

import java.util.*;
public class 字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str= in.nextLine();
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<26;i++){
                for(int j=0;j<str.length();j++){
                    char c = str.charAt(j);
                    if(i+'A'==c || i+'a'==c){
                        builder.append(String.valueOf(c));
                    }
                }
            }

            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(!(c>='a'&&c<='z') && !(c>='A'&&c<='Z')){
                    builder.insert(i,String.valueOf(c));
                }
            }
            System.out.println(builder.toString());
        }
    }
}
