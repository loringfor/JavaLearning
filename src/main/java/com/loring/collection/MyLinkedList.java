package com.loring.collection;

class ListNode{
    Object val;
    ListNode pre;
    ListNode next;

    public ListNode(){}
    public ListNode(Object val, ListNode pre, ListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}

public class MyLinkedList{
    private ListNode first;
    private ListNode last;

    private int size;

    public void add(Object obj){
        ListNode node = new ListNode();
        if(first==null){
            node.val = obj;
            node.pre=null;
            node.next=null;
            first = node;
            last = node;
        }else{
            node.val = obj;
            node.pre = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
    }

    public Object get(int index){
        rangeCheck(index);
        ListNode temp = first;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.val;

    }

    public Object remove(int index){
        rangeCheck(index);
        ListNode temp = first;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        ListNode up = temp.pre;
        ListNode down = temp.next;
        if(up==null && down==null){
            first=null;
            last=null;
        } else if(up==null){
            first=down;
        } else if(down==null){
            last = up;
        }else {
            up.next=down;
            down.pre=up;
        }
        size--;
        return temp.val;
    }

    private void rangeCheck(int index){
        if(index<0 || index>=size){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public int size(){
        return size;
    }

    public ListNode getFirst() {
        return first;
    }

    public ListNode getLast() {
        return last;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("aaa");
        myLinkedList.add(2);
        myLinkedList.add("CCC");
        System.out.println("size:"+myLinkedList.size());
        System.out.println("list.get():"+myLinkedList.get(1));
        myLinkedList.remove(0);
        System.out.println("size:"+myLinkedList.size());
        System.out.println(myLinkedList.get(0));

    }
}
