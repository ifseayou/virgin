package com.isea.penis.to20;

/**
 * @author isea_you
 * @date 2019/10/24
 * @time 19:43
 * @target: 输入一个链表，反转链表后，输出新链表的表头。
 *
 * !! 关键：pre起始的时候指向null；head + cur 就记这么多吧，多了也记不住！！
 */
public class Num15 {
    private static class ListNode{
        private int value;
        private ListNode next;
        public ListNode(){}
        public ListNode(int value){
            this.value = value;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printList(head);
        Num15 num15 = new Num15();
        ListNode tail = num15.ReverseList(head);
        printList(tail);

    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while(cur!= null){
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
