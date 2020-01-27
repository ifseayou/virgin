package com.isea.penis.to20;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/10/24
 * @time 19:24
     * @target: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Num14 {
    private static class ListNode{
        private int value;
        private ListNode next;
        public ListNode(){}
        public ListNode(int value){
            this.value = value;
            next = null;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode cur = head;
        ArrayList<ListNode> res = new ArrayList<>();
        while(cur != null){
            res.add(cur);
            cur = cur.next;
        }

        if (k > res.size()){
            throw new IllegalArgumentException("Illegal K...");
        }
        return res.get(res.size() - k);
    }

    public static void main(String[] args) {
        Num14 num14 = new Num14();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(num14.FindKthToTail(head, 1).value);
        System.out.println(num14.FindKthToTail(head, 2).value);
        System.out.println(num14.FindKthToTail(head, 3).value);
        System.out.println(num14.FindKthToTail(head, 4).value);
        System.out.println(num14.FindKthToTail(head, 5).value);
    }
}
