package com.interview.剑指offer;

import com.interview.ListNode;

public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null)
            return null;
        ListNode pre = new ListNode(0);
        ListNode head=pre;
        pre.next=pHead;
        ListNode p=pHead;
        while(p!=null){
            ListNode q=p.next;
            if(q==null)
                break;
            if(p.val==q.val){
                while(q.next!=null && q.next.val==q.val)
                    q=q.next;
                pre.next=q.next;
                p=pre.next;
            }else{
                pre=p;
                p=q;
            }
        }
        return head.next;
    }
}
