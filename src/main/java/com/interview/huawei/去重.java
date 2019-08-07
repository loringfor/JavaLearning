package com.interview.huawei;

import java.util.*;

public class 去重 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            // a:3,b:5,c:2@a:3,b:2
            String str = in.next();
            String[] strs = str.split("@");
            String[] use = strs[0].split(",");
            Map<String,Integer> map = new LinkedHashMap<>();
            for(int i=0;i<use.length;i++){
                String[] temp = use[i].split(":");
                String key = temp[0];
                int value = Integer.parseInt(temp[1]);
                map.put(key,value);
            }

            if(strs.length<2){

            }else {
                String[] used = strs[1].split(",");
                for(int i=0;i<used.length;i++){
                    String[] temp = used[i].split(":");
                    String key = temp[0];
                    int value = Integer.parseInt(temp[1]);
                    map.put(key,map.get(key)-value);
                }
            }

            StringBuilder builder = new StringBuilder();
            Iterator iterator = map.entrySet().iterator();
            int count=0;
            while (iterator.hasNext()){
                Map.Entry<String,Integer> entry = (Map.Entry<String,Integer>)iterator.next();
                String key = entry.getKey();
                int value =entry.getValue();
//                count++;
//                if(count!=map.size())
//                    System.out.print(key+":"+value+",");
//                else
//                    System.out.println(key+":"+value);
                if(value>0)
                    builder.append(key+":"+value+",");
            }
            String temp =builder.toString();

            String res="";
            if(temp.length()>1)
                res = temp.substring(0,temp.length()-1);
            System.out.println(res);
        }
    }
}
