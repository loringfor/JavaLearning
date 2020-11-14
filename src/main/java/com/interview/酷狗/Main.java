package com.interview.酷狗;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            // 符号栈
            Stack<String> ops = new Stack<>();
            // 数值栈,由于不需要运算,参数类型使用String,而非double;
            Stack<String> vals = new Stack<>();
            for(int i=0;i<str.length();i++) {
                String s = String.valueOf(str.charAt(i));
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    ops.push(s);
                } else if (s.equals(")")) {
                    String exp = ")" + vals.pop() + ops.pop() + vals.pop() + "(";
                    vals.push(exp);
                } else{
                    vals.push(s);
                }
            }
            StringBuilder res = new StringBuilder();
            while(!vals.isEmpty()){
                res.append(vals.pop());
            }
            res.reverse();
            System.out.println(res.toString());
        }
    }
}
