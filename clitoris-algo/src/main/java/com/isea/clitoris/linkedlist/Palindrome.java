package com.isea.clitoris.linkedlist;

import java.util.Stack;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/19 8:50
 * @target: 1->2->2->1 返回 true，判断一个链表是否为回文结构
 */
public class Palindrome {
    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    /**
     * space N
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head){
        Stack<Node> help = new Stack<>();
        Node cur= head;
        while(cur !=null){
            help.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if (head.data != help.pop().data){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * space N/2
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head){
        if (head == null ||head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        // 奇数的时候right中点下一个，偶数的时候在中点下一个。
        while(cur.next !=null && cur.next.next !=null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> help = new Stack<>();
        while(right != null){
            help.push(right);
            right = right.next;
        }
        while(!help.isEmpty()){
            if (head.data != help.pop().data){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * space 1;原地修改链表后半部分的结构。
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next !=null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while(n1 !=null && n2!=null){
            if (n1.data != n2.data){
                res = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while(n1!=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
