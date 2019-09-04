package com.interview.拼多多;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            String[] strs = str.split(";");
            String[] numsStr = strs[0].split(",");
            int N = Integer.parseInt(strs[1]);
            int[] nums = new int[numsStr.length];
            List<Integer> odd = new ArrayList<>();
            List<Integer> ou = new ArrayList<>();

            for(int i=0;i<nums.length;i++){
                int temp = Integer.parseInt(numsStr[i]);
                if(temp%2==1){
                    odd.add(temp);
                }else {
                    ou.add(temp);
                }
            }

            Collections.sort(ou);
            Collections.sort(odd);

            StringBuilder stringBuilder = new StringBuilder();
            if(N <= ou.size()){
                for(int i=0;i<N;i++){
                    stringBuilder.append(ou.get(ou.size()-i-1)).append(",");
                }
            }else {
                for(int i=0;i<ou.size();i++){
                    stringBuilder.append(ou.get(ou.size()-i-1)).append(",");
                }

                for(int j=0;j<N-ou.size();j++){
                    stringBuilder.append(odd.get(odd.size()-j-1)).append(",");
                }
            }

            String res=stringBuilder.substring(0,stringBuilder.length()-1);
            System.out.println(res);

        }
    }
}
