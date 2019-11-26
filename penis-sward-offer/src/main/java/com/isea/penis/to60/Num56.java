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

    /**
     * 使用HashSet的方式实现，额外空间复杂度O(N)
     * @param pHead
     * @return 如果有环，返回入环节点，如果没有环，返回null
     */
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

    /**
     * 使用快慢指针的方式
     * @param node
     * @return 有环返回入环节点，无环返回null
     */
    public ListNode EntryNodeOfLoop2(ListNode node){
        if (node == null || node.next == null || node.next.next == null){
             return null;
        }
        ListNode fast = node.next.next;
        ListNode slow = node.next;
        while(slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = node;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }



    public static void main(String[] args) {
        Num56 num56 = new Num56();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(num56.EntryNodeOfLoop(head1));
        System.out.println(num56.EntryNodeOfLoop2(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = head2.next.next;
        System.out.println(num56.EntryNodeOfLoop(head2).val);
        System.out.println(num56.EntryNodeOfLoop2(head2).val);
    }
}

