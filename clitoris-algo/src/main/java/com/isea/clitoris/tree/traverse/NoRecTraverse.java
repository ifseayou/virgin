package com.isea.clitoris.tree.traverse;

import java.util.Stack;

/**
 * 二叉树的非递归先序遍历
 */
public class NoRecTraverse {
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /**
     * 先序遍历=> 借助辅助栈实现
     */
    public static void preOrder(Node head){
        System.out.println("Pre-Order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.data);
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }


    /**
     *中序遍历,左根右，如果当前节点为null，从栈中取出一个元素打印，当前节点往右；如果当前节点不为null，当前节点入栈，当前节点向左
     */
    public static void inOrder(Node head){
        System.out.println("In-Order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.data);
                    head = head.right;
                }
            }
        }
        System.out.println();
    }


    /**
     * 后续遍历，左右根 ： 先实现根右左，打印的时候不打印，而是放入到栈中
     */
    public static void postOrder(Node head){
        System.out.println("Post-Order:");
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null){
                    stack1.push(head.left);
                }
                if (head.right != null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().data);
            }
        }
        System.out.println();
    }

    // 层序遍历：在PrintFromToToBottom中已经写了
}
