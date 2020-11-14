package com.interview.leetcode;

import com.interview.ListNode;

public class 反转链表206 {

    // 迭代
    public static ListNode reverseList(ListNode head) {
        ListNode pre=null,next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    // 递归
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reverse(head);
    }
}
