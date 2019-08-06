package com.interview;

import java.util.*;

public class 输入样例 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int len = in.nextInt();
            int num = in.nextInt();
            // 因为后面使用的是nextLine，所以要先把吞的前面的回车去掉
            // 使用next则不需要，但是next不支持有空格的一行
            in.nextLine();
            String[] strs = new String[len];
            for(int i=0; i<len; i++){
                strs[i]=in.nextLine();
            }
        }
    }
}
