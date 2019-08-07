package com.interview.huawei;

import java.io.*;
import java.util.*;

public class 简单错误记录 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        String[] errors;
        String fileName;
        // 注意：这里采用的是LinkedHashMap
        Map<String,Integer> map = new LinkedHashMap<>();
        while ((str=in.readLine())!=null){
            errors = str.split("\\s+");
            fileName = errors[0].substring(errors[0].lastIndexOf('\\')+1);
            //处理长度超过16的情况
            if(fileName.length() > 16){
                fileName = fileName.substring(fileName.length() - 16);
            }
            String key = fileName+" "+errors[1];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        //输出错误信息,最多8条(后八条)
        int count = 0;
        for (String key:map.keySet()){
            count++;
            // 最后8条
            if(count > (map.size() -8)){
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
