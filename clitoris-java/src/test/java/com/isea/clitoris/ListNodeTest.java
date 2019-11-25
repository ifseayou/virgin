package com.isea.clitoris;

import org.junit.Test;

/**
 * @author isea_you
 * @date 2019/11/25
 * @time 20:14
 * @target:
 */
public class ListNodeTest {
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static int getLengthNext(ListNode head){
        ListNode cur = head;
        int n = 0;
        while(cur.next != null){
            n ++;
            cur = cur.next;
        }
        return n;
    }

    public static int getLength(ListNode head){
        ListNode cur = head;
        int n = 0;
        while(cur != null){
            n ++;
            cur = cur.next;
        }
        return n;
    }

    @Test
    public void testListNode(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println("next:" + getLengthNext(head)); // 3  当前节点会停留在最后一个节点
        System.out.println("cur:" + getLength(head)); // 4 当前节点会停留在null的位置
    }
}
