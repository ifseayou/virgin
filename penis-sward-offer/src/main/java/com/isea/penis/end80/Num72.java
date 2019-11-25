package com.isea.penis.end80;

/**
 * @author isea_you
 * @date 2019/11/25
 * @time 18:52
 * @target: 寻找两个单链表的相交节点，注意链表可能有环，也可能无环
 */
public class Num72 {
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersection(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null){
            return null;
        }

        // 获取链表的入环节点，有环返回入环节点，无环返回null
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        // 两个无环链表的相交节点
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }

        // 两个有环链表的相交节点
        if (loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }

        // 一个链表有环，另外一个链表无环，一定不会相交
        return null;
    }

    /**
     * 两个链表都有环：
     * 1： 6 + 6 没有相交
     * 2： 倒画的小人，此时只有一个相交节点，和两个无环链表相交逻辑差不多
     * 3： A型，此时有两个相交的节点
     * @param head1
     * @param loop1 入环节点
     * @param head2
     * @param loop2
     * @return
     */
    private ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2){ // 情况2，相交一个节点
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n ++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n --;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0){
                n --;
                cur1 = cur1.next;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next; // 从入环节点的下一位置开始，在环内移动
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }

    /**
     * 两个无环链表的相交节点，获取两个链表的长度，长链表先走长度差个节点，第一次相交的节点就是相交的节点
     * 这里可以使用一个变量来表征长度差
     * @param head1
     * @param head2
     * @return
     */
    private ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        int n = 0; // 长度差
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(cur1.next != null){
            n ++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            n --;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){ // 最后一节点不相等，一定不相交
            return null;
        }
        cur1 = n > 0 ? head1 : head2; // cur1 -> 长链表
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while( n != 0){ // 长链表先走长度差
            n --;
            cur1 = cur1.next;
        }

        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    /**
     * 快2，慢1，如果有环，相遇之后，快回到头改为慢指针，再次相遇的节点即为入环节点
     * @param head
     * @return
     */
    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        // 定义快慢指针
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast){
            if (fast.next == null || fast.next.next == null){ // 快指针提前遇到了null，说明无环
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head; // back to head
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;// 或者是fast都OK
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        Num72 num72 = new Num72();

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(8);
        head2.next.next = head1.next.next;

        // 两个无环链表的相交节点
        System.out.println(num72.getIntersection(head1, head2).val);


        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(5);
        head3.next.next.next = new ListNode(6);
        head3.next.next.next.next = new ListNode(7);
        head3.next.next.next.next.next = head3.next.next;

        ListNode head4 = new ListNode(3);
        head4.next = new ListNode(4);
        head4.next.next = head3.next.next;

        // 一个相交节点
        System.out.println(num72.getIntersection(head3,head4).val);


        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);
        head5.next.next.next = new ListNode(4);
        head5.next.next.next.next = head5.next;

        ListNode head6 = new ListNode(9);
        head6.next = head5.next.next.next;
        // 两个节点 A型
        System.out.println(num72.getIntersection(head5,head6).val);


        ListNode head7 = new ListNode(1);
        ListNode head8 = new ListNode(9);
        System.out.println(num72.getIntersection(head7,head8));

        System.out.println(num72.getIntersection(head1,head8));
    }
}
