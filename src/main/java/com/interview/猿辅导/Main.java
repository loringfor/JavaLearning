//package com.interview.猿辅导;
//
//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
//}
//
//
//class CircleNode{
//    int size;
//    ListNode head;
//    ListNode tail;
//    public CircleNode(int size){
//        head = new ListNode(-1);
//        tail = new ListNode(-1);
//        node = head;
//        for(int i=1;i<=size-2;i++){
//            node.next = new ListNode(-1);
//        }
//        node.next=tail;
//        tai.next=head;
//    }
//
//    ListNode m=head,n=head;
//    public void add(int val){
//        if(n.val==-1){
//            n.val=val;
//            n=n.next;
//        }else{
//            ListNode next= n.next;
//            n.next = new ListNode(val);
//            n=n.next;
//            n.next=next;
//        }
//    }
//
//    public void delete(){
//        if(m.val!=-1){
//            m.val=-1;
//            m=m.next;
//        }else{
//            throw new NullException();
//        }
//    }
//
//}
//
//class ListNode{
//    int val;
//    ListNode pre;
//    ListNode next;
//    public ListNode(int val){
//        this.val = val;
//    }
//}
