package com.isea.penis.to60;
import java.util.HashSet;

/**
 * @author isea_you
 * @date 2019/11/22
 * @time 10:43
 * @target: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Num56 {
    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashSet help = new HashSet<ListNode>();
        ListNode cur = pHead;
        while (cur != null) {
            if (help.contains(cur)) {
                return cur;
            }
            help.add(cur);
            cur = cur.next;
        }
        return null;
    }


    public static void main(String[] args) {
        Num56 num56 = new Num56();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(num56.EntryNodeOfLoop(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = head2.next.next;
        System.out.println(num56.EntryNodeOfLoop(head2).val);
    }
}

