package com.isea.penis.to10;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 11:52
 * @target: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Num3 {
    private static class ListNode{
        private int value;
        private ListNode next;
        public ListNode(){}
        public ListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while(cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        Num3 num3 = new Num3();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(num3.printListFromTailToHead(head));
    }
}
