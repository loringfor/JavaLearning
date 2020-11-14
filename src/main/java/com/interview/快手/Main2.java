package com.interview.快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            List<String> list = letterCombinations(str);
            StringBuilder res = new StringBuilder("[");
            for(int j=0;j<list.size();j++){
                res.append(list.get(j)+", ");
            }
            String ans = res.substring(0,res.length()-2);
            System.out.println(ans+"]");
        }
    }

    public static List<String> letterCombinations(String digits) {
        int length=digits.length();
        List<String> list = new ArrayList();
        if(digits==null||length<1)
            return list;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        count(list,digits,map,"");
        return list;
    }

    public static void count(List<String> list, String digits, String[] map, String cur){
        if(cur.length()==digits.length()){
            list.add(cur);
            return;
        }
        int index = digits.charAt(cur.length())-'0';
        for(int i=0;i<map[index].length();i++){
            count(list,digits,map,cur+map[index].charAt(i));
        }
    }
}
