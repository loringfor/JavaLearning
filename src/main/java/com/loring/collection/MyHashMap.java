package com.loring.collection;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 自定义Map升级版
 * 1.提高查询效率
 */
public class MyHashMap {
    LinkedList[] array=new LinkedList[100]; //map的底层结构就是：数组+链表
    int size=0;

    public void put(Object key,Object value){
        MyEntry myEntry=new MyEntry(key,value);
        int a=Math.abs(key.hashCode() % array.length);
        if(array[a]==null){
            LinkedList list=new LinkedList();
            array[a]=list;
            list.add(myEntry);
        }else {
            LinkedList list=array[a];
            for (int i = 0; i < list.size(); i++) {
                MyEntry myEntry1=(MyEntry) list.get(i);
                if (myEntry1.key.equals(key)){
                    myEntry1.value=value; //键重复时候覆盖
                    return;
                }
            }

            array[a].add(myEntry);
        }
    }

    public Object get(Object key){
        int a=Math.abs(key.hashCode() % array.length);
        if(array[a]!=null){
            LinkedList list=array[a];
            for (int i = 0; i < list.size(); i++) {
                MyEntry myEntry=(MyEntry) list.get(i);
                if(key.equals(myEntry.key))
                    return myEntry.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap=new MyHashMap();
        myHashMap.put("Loring",new Wife("小龙女"));
        Wife wife=(Wife)myHashMap.get("Loring");
        System.out.println(wife.getName());
    }

}

class MyEntry{
    Object key;
    Object value;

    public MyEntry(){}
    public MyEntry(Object key, Object value){
        this.key=key;
        this.value=value;
    }
}

class Wife{
    String name;
    public Wife(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}