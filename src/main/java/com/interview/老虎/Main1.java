package com.interview.老虎;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    static int small=0,middle=0,large=0;

    public static boolean judge(String str){
        Stack<Character> stack = new Stack();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                small++;
                stack.push(c);
            }
            if(c=='[' && small==0){
                middle++;
                stack.push(c);
            }
            if(c=='[' && small!=0){
                return false;
            }
            if(c=='{' && small==0 && middle==0 ){
                large++;
                stack.push(c);
            }
            if(c==')'||c==']'||c=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(isEquals(c,stack.peek())){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isEquals(char c1,char c2){
        if(c2=='('){
            if(c1==')'){
                small--;
                return true;
            }else{
                return false;
            }
        }
        if(c2=='['){
            if(c1==']'){
                middle--;
                return true;
            }else{
                return false;
            }
        }
        if(c2=='{'){
            if(c1=='}'){
                large--;
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            System.out.println(judge(str));
        }
    }
}
