package com.isea.penis.to60;

/**
 * @author isea_you
 * @date 2019/11/21
 * @time 20:21
 * @target: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Num57 {

    public static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        ListNode head = new ListNode(0);
        head.next = pHead; // 处理上来就是重复的元素的情况，1->1
        ListNode cur = pHead;
        ListNode pre = head;
        while(cur != null){
            if (cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.val == cur.next.val){ // 找到最后一个重复的节点，在此之前要判断cur.next是存在的
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Num57 num57 = new Num57();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode res = num57.deleteDuplication(head);
        ListNode cur = res;
        while(cur != null){
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }
}
