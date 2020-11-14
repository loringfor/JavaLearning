package com.interview.流利说;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (in.hasNextLine()){
            String s = in.nextLine();
            if(s==null || "".equals(s)){
                break;
            }
            list.add(s);
        }
        int row = list.size();
        System.out.println(row*row/2);
    }
}
