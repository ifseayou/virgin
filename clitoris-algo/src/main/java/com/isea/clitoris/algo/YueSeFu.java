package com.isea.clitoris.algo;
public class YueSeFu {
    public static class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
        @Override
        public String toString() {
            return "" + val;
        }
    }

    // 形成一个单向循环链表
    public static Node generateList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N 必须大于0");
        }
        Node head = new Node(1);
        Node p = head; // 尾节点指向头结点
        for (int i = 2;i <= n ; i ++){
            p.next = new Node(i);
            p = p.next;
        }

        p.next = head;
        return p;
    }

    public static  void printCircleQueue(Node tail){
        Node p = tail.next;
        while(p != tail){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.print(tail);
        System.out.println();
    }

    private static int getLuckyBoy(int n, int m) {
        Node p = generateList(n);
        while(p != p.next){
            for (int i = 1; i < m; i ++){
                p = p.next;
            }
            p.next = p.next.next;
        }
        return p.val;
    }

    public static void main(String[] args) {
        printCircleQueue(generateList(8));
        System.out.println(getLuckyBoy(8, 3));
    }
}
