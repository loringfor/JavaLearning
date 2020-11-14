package com.interview.招商卡中心;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int len = str.length();
            int[] res = new int[len];
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<len;i++){
                char c = str.charAt(i);
                if(c=='R'){
                    for(int j=i+1;j<len;j++){
                        if(c != str.charAt(j)){
                            map.put(i,j);
                            break;
                        }
                    }
                }else{
                    for(int j=i-1;j>=0;j--){
                        if(c != str.charAt(j)){
                            map.put(i,j);
                            break;
                        }
                    }
                }
            }

            Set<Map.Entry<Integer,Integer>> set = map.entrySet();
            for(Map.Entry<Integer,Integer> entry:set){
                int key= entry.getKey();
                int value = entry.getValue();
                int temp = value-key;
                if(temp>0){
                    if(temp%2==0){
                        res[value]++;
                    }else {
                        res[value-1]++;
                    }
                }else{
                    temp = -temp;
                    if(temp%2==0){
                        res[value]++;
                    }else{
                        res[value+1]++;
                    }
                }
            }

            for(int i=0;i<res.length;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}
