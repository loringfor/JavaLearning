package com.interview.小红书;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(c>='a' && c<='z' || c=='('){
                    stack.push(c);
                }else if(c=='<'){
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.push(c);
                    }
                    else if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else if(c==')'){
                    while (!stack.isEmpty() && stack.peek()!='('){
                        stack.pop();
                    }
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()){
                res.append(stack.pop());
            }
            res.reverse();
            System.out.println(res.toString());

        }
    }
}
