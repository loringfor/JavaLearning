package com.interview.leetcode;

import com.interview.ListNode;

public class 回文链表234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }

        ListNode tail =pre;
        while(head!=null && pre!=null){
            if(head.val!=pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        pre=null;
        while(tail!=null){
            ListNode next = tail.next;
            tail.next=pre;
            pre = tail;
            tail =next;
        }
        return true;
    }
}
