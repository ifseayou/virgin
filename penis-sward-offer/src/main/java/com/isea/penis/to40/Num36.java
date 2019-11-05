package com.isea.penis.to40;

import java.util.HashSet;

/**
 * @author isea_you
 * @date 2019/11/5
 * @time 11:55
 * @target: 输入两个链表，找出它们的第一个公共结点。
 */
public class Num36 {
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<Integer> help = new HashSet<>();
        ListNode cur = pHead1;
        while(cur != null){
            help.add(cur.val);
            cur = cur.next;
        }
        cur = pHead2;
        while(cur != null){
            if (help.contains(cur.val)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public static void main(String[] args) {
        Num36 num36 = new Num36();
        ListNode pHead1 = new ListNode(1);
        ListNode pHead2 = new ListNode(2);
        pHead1.next = new ListNode(3);
        pHead2.next = new ListNode(4);
        pHead1.next.next = new ListNode(4);
        pHead2.next.next = new ListNode(5);
        System.out.println(num36.FindFirstCommonNode(pHead1, pHead2).val);
    }
}
