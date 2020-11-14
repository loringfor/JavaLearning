package com.interview.快手;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            String res =core(str);
            System.out.println(res);
        }
    }

    public static String core(String str){
        if(str.indexOf(".")>=0){
            String[] strs = str.split("\\.");
            if(strs.length!=4){
                return "Neither";
            }
            for(int i=0;i<strs.length;i++){
                if(!judgeIPv4(strs[i])){
                    return "Neither";
                }
            }
            return "IPv4";

        }else if(str.indexOf(":")>=0){
            String[] strs = str.split(":");
            if(strs.length!=8){
                return "Neither";
            }
            for(int i=0;i<strs.length;i++){
                if(!judgeIPv6(strs[i])){
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static boolean judgeIPv6(String str){
        if(str.length()==0 || str == null){
            return false;
        }
        if(str.length() == 1 && str.charAt(0)=='0'){
            return true;
        }
        if(str.length()>4){
            return false;
        }

        boolean flag = true;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if((c>='0' && c<='9') || (c>='a' && c<='f') || (c>='A' && c<='F') ){

            }else {
                return false;
            }
            if(c!='0'){
                flag = false;
            }
        }
        if(flag){
            return false;
        }
        return true;
    }

    public static boolean judgeIPv4(String str){
        if(str.length()>3){
            return false;
        }
        boolean flag =true;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(flag && c=='0'){
                return false;
            }else {
                flag = false;
            }
        }
        if(Integer.parseInt(str)<256){
            return true;
        }else {
            return false;
        }
    }

}
