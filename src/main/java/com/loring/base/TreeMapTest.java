package com.loring.base;

import java.util.*;
;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer,String> tree = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        tree.put(6,"BBBBBB");
        tree.put(1,"AAAAAAA");
        tree.put(17,"MMMMMM");
        Iterator<Map.Entry<Integer,String>> iterator = tree.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("########################");

        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(6,"BBBBBB");
        hashMap.put(1,"AAAAAAA");
        hashMap.put(17,"MMMMMM");
        Iterator<Map.Entry<Integer,String>> iter= hashMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer,String> entry = iter.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
