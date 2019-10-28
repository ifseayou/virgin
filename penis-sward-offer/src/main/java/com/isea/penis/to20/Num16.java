package com.isea.penis.to20;

import java.util.Stack;

/**
 * @author isea_you
 * @date 2019/10/25
 * @time 8:37
 * @target: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Num16 {
    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                stack.push(cur1);
                cur1 = cur1.next;
            } else {
                stack.push(cur2);
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            stack.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack.push(cur2);
            cur2 = cur2.next;
        }

        ListNode head = new ListNode();
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            cur.next = head.next;
            head.next = cur;
        }
        return head.next;
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        ListNode head = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.value <= list2.value){
                dummyHead.next = list1;
                dummyHead = list1;
                list1 = list1.next;

            }else{
                dummyHead.next = list2;
                dummyHead = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            dummyHead.next = list1;
        }
        if(list2 != null){
            dummyHead.next = list2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Num16 num16 = new Num16();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        ListNode mergeList = num16.Merge(head1, head2);

        ListNode cur = mergeList;
        while(cur != null){
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.print("null");
    }
}
