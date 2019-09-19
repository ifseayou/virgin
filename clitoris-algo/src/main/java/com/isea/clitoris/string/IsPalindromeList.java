package com.isea.clitoris.string;

import java.util.Stack;

/**
 * @author isea_you
 * @date 2019/8/21
 * @time 8:12
 * @target:
 *
 *  给定一个链表的头节点head，请判断该链表是否为回文结构。
 *  例如： 1->2->1，返回true。 1->2->2->1，返回true。 15->6->15，返回true。 1->2->3，返回false
 */

public class IsPalindromeList {
    public static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value = data;
        }
    }

    // need extra space:定义一个stack，连快慢指针都不需要设置
    public static boolean isPalindroneOne(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void  printLinkedList(Node head){
        System.out.print("LinkedList:");
        while(head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print("Null");
        System.out.println();
    }
    public static void main(String[] args) {

        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindroneOne(head));
    }
}
