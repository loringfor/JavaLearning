package com.interview;

import java.util.Stack;

public class 中缀表达式转成后缀表达式 {

    public static String infixToSuffix(String expression){
        if(expression==null || expression.length()<1)
            return null;
        int len = expression.length();
        StringBuilder res= new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++){
            char c=expression.charAt(i);
            if(c=='+' || c=='-'){
                if(stack.isEmpty() || stack.peek()=='('){
                    stack.push(c);
                }else{
                    while(!stack.isEmpty() && (stack.peek()=='*' ||
                            stack.peek()=='/' || stack.peek()=='+' || stack.peek()=='-')){
                        res.append(stack.pop());
                    }
                    stack.push(c);
                }
            }else if(c=='*' || c=='/'){
                while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')){
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

    public static void main(String[] args) {
        System.out.println(infixToSuffix("2*(3+4)+6/2"));
    }
}
