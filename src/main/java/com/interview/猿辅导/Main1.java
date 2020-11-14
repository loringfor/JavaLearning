package com.interview.猿辅导;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static String change(String str){
        if(str==null || str.length()<1)
            return null;
        Stack<Character> stack = new Stack<>();
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<str.length();){
            char c = str.charAt(i);
            String temp ="";
            while (c>='0'&&c<'9'){
                temp +=String.valueOf(c);
                i++;
                if(i<str.length())
                    c = str.charAt(i);
                else
                    break;
            }

            if(!"".equals(temp)){
                int num = Integer.parseInt(temp);
                if(stack.peek()!=')'){
                    char c1 = stack.peek();
                    for(int j=0;j<num-1;j++){
                        stack.push(c1);
                    }
                }else if(stack.peek()==')'){
                    stack.pop();
                    StringBuilder stringBuilder = new StringBuilder();
                    while(stack.peek()!='('){
                        stringBuilder.append(String.valueOf(stack.pop()));
                    }
                    stringBuilder.reverse();
                    stack.pop();
                    String string ="";
                    for(int j=0;j<num;j++){
                        string+= stringBuilder.toString();
                    }
                    for(int j=0;j<string.length();j++){
                        stack.push(string.charAt(j));
                    }
                }
            }else {
                stack.push(c);
                i++;
            }

        }

        while (!stack.isEmpty()){
            builder.append(String.valueOf(stack.pop()));
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int len = in.nextInt();
            int m=in.nextInt();
            String[] strs = new String[len];
            in.nextLine();
            for(int i = 0;i<len;i++)
                strs[i] = in.nextLine();

            for (int i=0;i<len;i++){
                if(strs[i]==null || strs[i].equals(""))
                    System.out.println("WWWWWW");
                else
                    System.out.println(strs[i]);

            }
//            for(int i = 0;i<len;i++)
//                System.out.println(change(strs[i]));

        }
    }
}
