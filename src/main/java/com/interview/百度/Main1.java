package com.interview.百度;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int res=0;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                int x = in.nextInt();
                int y = in.nextInt();
                if(x>=m){
                    res+=y;
                }else{
                    for(int j=0;j<y;j++){
                        list.add(x);
                    }
                }
            }
            Collections.sort(list);
            int left=0,right=list.size()-1;
            while(left<right){
                int temp=list.get(left)+list.get(right);
                if(temp>=m){
                    res++;
//                    list.remove(left);
                    left++;
//                    list.remove(right);
                    right--;
                }else{
                    left++;
                }
            }
            System.out.println(res);
        }
    }
}
