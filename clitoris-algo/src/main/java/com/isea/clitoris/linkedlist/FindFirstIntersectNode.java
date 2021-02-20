package com.isea.clitoris.linkedlist;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/20 16:45
 * @target: 关于链表的最难的一到题目，两个单链表一系列的相交问题。
 * 两个链表的表头分别为：head1,head2
 * 单链表可能有环，可能无环；
 * 这两个链表可能相交，可能不相交
 * 要求：实现一个函数，如果两个链表相交，返回相交的第一个节点，如果不想交，返回null
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        // 获取两链表第一个入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        // 两个都无环，进一步有相交的可能性
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }

        // 两个都有环，才有进一步相交的可能性
        if (loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }

        // 一个有环一个无环，不可能相交
        return null;
    }

    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1.next != null){
                n ++;
                cur1 = cur1.next;
            }
            while(cur2.next != null){
                n --;
                cur2 = cur2.next;
            }
            if (cur1 != cur2){
                return null;
            }
            cur1 = n > 0 ? head1: head2;
            cur2 = cur1 == head1? head2:head1;
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
            cur1 = loop1.next;
            while(cur1 == loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next != null){
            n ++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            n --;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1: head2;
        cur2 = cur1 == head1? head2:head1;
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
    }

    /**
     * 快慢指针跑出第一个入环节点，
     * slow 一次走一步、fast 一次走两步，第一次相遇之后，fast从头开始一次一步，第二次相遇的时候即为入环节点。
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head; // walk again from head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
