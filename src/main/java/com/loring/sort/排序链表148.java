package com.loring.sort;

import com.interview.ListNode;

public class 排序链表148 {

    // 基于归并排序
    public static ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode slow=head, fast=head, node=null;
        while (fast!=null && fast.next!=null){
            node = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        node.next=null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left,right);
    }

    public static ListNode merge(ListNode left,ListNode right){
        if(left==null) {
            return right;
        }
        if(right==null) {
            return left;
        }
        ListNode list;
        if(left.val<=right.val){
            list=left;
            list.next=merge(left.next,right);
        }else{
            list=right;
            list.next=merge(left,right.next);
        }
        return list;
    }

    public static void main(String[] args) {
//        -1->5->3->4->0
        ListNode head=new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        System.out.println(sortList(head).val);
    }

    //采用快速排序
     public ListNode quickSortList(ListNode head) {
        quickSort(head, null);
        return head;
     }

     public static void quickSort(ListNode head, ListNode end) {
         if (head != end) {
             ListNode node = partion(head, end);
             quickSort(head, node);
             quickSort(node.next, end);
         }
     }

     public static ListNode partion(ListNode head, ListNode end) {
         ListNode p1 = head, p2 = head.next;
         //走到末尾才停
         while (p2 != end) {
             //大于key值时，p1向前走一步，交换p1与p2的值
             if (p2.val < head.val) {
                 p1 = p1.next;

                 int temp = p1.val;
                 p1.val = p2.val;
                 p2.val = temp;
             }
             p2 = p2.next;
         }

         //当有序时，不交换p1和key值
         if (p1 != head) {
             int temp = p1.val;
             p1.val = head.val;
             head.val = temp;
         }
         return p1;
     }
}
