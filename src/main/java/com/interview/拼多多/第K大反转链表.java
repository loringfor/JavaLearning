package com.interview.拼多多;

import com.interview.ListNode;

import java.util.PriorityQueue;

public class 第K大反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode node = reverse(head,3);
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public static ListNode reverse(ListNode head,int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>(K);
        ListNode first = head,node =head;
        while(head!=null){
            if(queue.size()<K){
                queue.add(head.val);
            }else{
                if(head.val>queue.peek()){
                    queue.poll();
                    queue.add(head.val);
                }
            }
            head = head.next;
        }
        int num = queue.peek();
        System.out.println(num);

        ListNode pre=null, next=null;
        while(first!=null && first.val!=num){
            next=first.next;
            first.next=pre;
            pre = first;
            first =next;
        }
        node.next = next;
        System.out.println(pre.val);
        return pre;
    }

}
