package com.interview.阿里;

import java.util.*;

public class Main2 {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
//    bgbbbgbggbgbg
    static String getIndexAndLongest(String users,int k) {
        int len = users.length();
        int left,right;
        int index=0,max=0;
        for(int i=0;i<len;i++){
            char c = users.charAt(i);
            if(c=='b'){
                int count=0;
                left=i-1;
                right=i+1;
                while(left>=0 &&users.charAt(left)=='g'){
                    count++;
                    left--;
                }
                while(right<len && users.charAt(right)=='g'){
                    count++;
                    right++;
                }
                if(count>max){
                    index=i;
                    max=count;
                }
            }
        }

        int girls=0;
        int res=0;
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<len;i++){
            char c=users.charAt(i);
            if(c=='g'){
                girls++;
                list.add(i);
            }
        }

        for(int i=0;i<list.size()-k-1;i++){
            int temp=list.get(i+k+1)-list.get(i)+1-k-2;
            res =Math.max(res,temp);
        }

        if(k>=girls){
            res=len;
        }
        return new String(index+" "+ res);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        int k = in.nextInt();

        res = getIndexAndLongest(_users,k);
        System.out.println(res);
    }
}
