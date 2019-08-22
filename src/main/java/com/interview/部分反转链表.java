package com.interview;

public class 部分反转链表 {
    /**
     * 翻转链表的从结点m到结点n的部分
     *
     * @param head 连标点额头结点
     * @param m 翻转的开始位置
     * @param n 翻转的结束位置
     * @return 翻转后的新链表
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;
        for(int i=0;i<m-1;i++){
            cur = cur.next;
        }

        ListNode pre = null, node = cur.next;
        for(int i=0;i<=n-m;i++){
            ListNode next = node.next;
            node.next=pre;
            pre = node;
            node = next;
        }

        cur.next.next = node;
        cur.next = pre;

        return fake.next;

    }

    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseBetween(head,2,4);
        print(head);
    }

    /**
     * 打印输出链表的结点值
     */
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}

