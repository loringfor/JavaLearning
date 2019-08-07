package com.interview.huawei;

import java.util.Scanner;
import java.util.Stack;

public class 中缀转后缀 {

    // !(1&0)|0&1   !>&>|
    // !(1&0)&0|0
    // 中缀转后缀
    public static String infixToSuffix(String expression){
        if(expression==null || expression.length()<1)
            return null;
        int len = expression.length();
        StringBuilder res= new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++){
            char c=expression.charAt(i);
            if(c=='|'){
                if(stack.isEmpty() || stack.peek()=='('){
                    stack.push(c);
                }else{
                    while(!stack.isEmpty() && (stack.peek()=='!' ||
                            stack.peek()=='|' || stack.peek()=='&')){
                        res.append(stack.pop());
                    }
                    stack.push(c);
                }
            }else if(c=='&'){
                while(!stack.isEmpty() && (stack.peek()=='!' || stack.peek()=='&')){
                    res.append(stack.pop());
                }
                stack.push(c);
            }else if(c=='!'){
                while(!stack.isEmpty() && (stack.peek()=='!')){
                    res.append(stack.pop());
                }
                stack.push(c);
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    res.append(stack.pop());
                }
                stack.pop();
            }else{
                res.append(c);
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static int core(String str){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if(c=='&'){
                int temp = stack.pop() & stack.pop();
                stack.push(temp);
            }else if(c=='|'){
                int temp = stack.pop() | stack.pop();
                stack.push(temp);
            }else if(c=='!'){
                int temp = stack.pop();
                if(temp==0)
                    temp=1;
                else if(temp==1)
                    temp=0;
                stack.push(temp);
            }else {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
        }

        if(!stack.isEmpty())
            return stack.peek();
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            String temp = infixToSuffix(str);
//            System.out.println(temp);
            int res = core(temp);
            System.out.println(res);
        }
    }
}
