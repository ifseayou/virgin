package com.isea.penis.to30;

import java.util.HashMap;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 17:49
 * @target: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Num25 {
    private static class RandomListNode {
        private int value;
        private RandomListNode next;
        private RandomListNode random;
        public RandomListNode(int value){
            this.value = value;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        HashMap<RandomListNode, RandomListNode> help = new HashMap<>();
        RandomListNode cur = pHead;
        while(cur != null){
            help.put(cur,new RandomListNode(cur.value));
            cur = cur.next;
        }
        cur = pHead;
        while(cur != null){
            help.get(cur).next = help.get(cur.next);
            help.get(cur).random = help.get(cur.random);
            cur = cur.next;
        }
        return help.get(pHead);
    }
    public static void main(String[] args) {
        Num25 nu25 = new Num25();
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head.next;
        head.next.next.random = head;
        RandomListNode clone = nu25.Clone(head);
        RandomListNode cur = clone;
        while(cur != null){
            System.out.print(cur.random.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
