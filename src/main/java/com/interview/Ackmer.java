package com.interview;

import java.util.Scanner;
import java.util.Stack;

public class Ackmer {
    public  static int ackerman(int m,int n){//m,n分别为acker的两个参数
        Stack<Integer> stack1=new Stack<Integer>(); //用栈来存储参数，s1存m,s2存n
        Stack<Integer> stack2=new Stack<Integer>();
        stack1.push(m);
        stack2.push(n);
        while(!stack1.isEmpty()){//s1为空时计算结束，s2此时存了结果
            int i=stack1.pop();//i,j分别存入s1，s2的栈顶，首次执行while循环存入的是m，n的值
            int j=stack2.pop();
            if(i==0){//if-elseif-elseif分别对应三种情况
                 stack2.push(j+1);
            }else if(i!=0&&j==0){
                stack1.push(i-1);
                stack2.push(1);
            }else if(i!=0&&j!=0){
                stack1.push(i-1);
                stack1.push(i);
                stack2.push(j-1);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println(dfs(m,n));
            System.out.println(ackerman(m,n));
        }
    }

    public static int dfs(int m,int n){
        if(m==0)
            return n+1;
        if(m!=0 && n==0)
            return dfs(m-1,1);
        return dfs(m-1,dfs(m,n-1));
    }
}
