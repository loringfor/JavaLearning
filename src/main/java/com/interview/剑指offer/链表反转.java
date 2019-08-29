package com.interview.剑指offer;

import com.interview.ListNode;

public class 链表反转 {

    public static ListNode ReverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
