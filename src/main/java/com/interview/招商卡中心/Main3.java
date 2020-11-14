package com.interview.招商卡中心;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int len = str.length();
            StringBuilder min = new StringBuilder();
            StringBuilder max = new StringBuilder();
            int[] origin = new int[len];
            Arrays.fill(origin,-1);
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(c=='?'){
                    min.append("0");
                    max.append("9");
                }else{
                    min.append(c);
                    max.append(c);
                    origin[i] = Integer.parseInt(String.valueOf(c));
                }
            }

            int start = Integer.parseInt(min.toString());
            int end = Integer.parseInt(max.toString());
            long count=0;
            for(int i=start;i<=end;i++){
                boolean flag = spilt(i,len,origin);
                if(flag==true && i%13==5){
                    count++;
                }
            }
            count = count %(int)(10e9+7);
            System.out.println(count);
        }
    }

    public static boolean spilt(int num,int len,int[] origin){
        int i=len-1;
        while (num!=0){
            int temp = num %10;
            if(origin[i]!=-1 && temp != origin[i]){
                return false;
            }
            i--;
            num = num /10;
        }
        return true;
    }
}
