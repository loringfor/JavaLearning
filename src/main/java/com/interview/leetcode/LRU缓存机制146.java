package com.interview.leetcode;

import java.util.*;

public class LRU缓存机制146 {
    DLinkedNode head,tail;
    int size;
    int capacity;
    HashMap<Integer,DLinkedNode> cache = new HashMap();

    public LRU缓存机制146(int capacity) {
        this.capacity = capacity;
        this.size=0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public void addNode(DLinkedNode node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }

    public void removeNode(DLinkedNode node){
        DLinkedNode pre=node.pre;
        DLinkedNode next=node.next;
        pre.next=next;
        next.pre=pre;
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    public DLinkedNode popTail(){
        DLinkedNode temp=tail.pre;
        removeNode(temp);
        return temp;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node==null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key,newNode);
            size++;
            if(size>capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }
}

class DLinkedNode{
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
}
