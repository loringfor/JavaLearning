package com.interview.leetcode;

import java.util.*;

public class 电话号码的字母组合17 {

    public List<String> letterCombinations(String digits) {
        int length=digits.length();
        List<String> list = new ArrayList();
        if(digits==null||length<1)
            return list;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        count(list,digits,map,"");
        return list;
    }

    public void count(List<String> list, String digits, String[] map, String cur){
        if(cur.length()==digits.length()){
            list.add(cur);
            return;
        }
        int index=digits.charAt(cur.length())-'0';
        for(int i=0;i<map[index].length();i++){
            count(list,digits,map,cur+map[index].charAt(i));
        }
    }
}
