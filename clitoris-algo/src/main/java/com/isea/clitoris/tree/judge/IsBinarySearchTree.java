package com.isea.clitoris.tree.judge;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 判断一棵树数是否是二分搜索树
 * <p>
 * 中序遍历是否是顺序的
 */
public class IsBinarySearchTree {

    static LinkedList<Integer> queue = new LinkedList<Integer>();

    private static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        queue.offer(head.data);
        inOrder(head.right);
    }

    public static boolean isBinarySearchTree1(TreeNode head) {
        inOrder(head);
        int min = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            if (min > value) {
                return false;
            }
            min = value;
        }
        return true;
    }

    /**
     * 判断是否是一颗二叉搜索树，非递归判断
     * @param head
     * @return
     */
    public static boolean isBinarySearchTree2(TreeNode head) {
        if (head != null){
            int min = Integer.MIN_VALUE;
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    if(head.data < min) return false;
                    else min = head.data;
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(1);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);

        System.out.println(isBinarySearchTree1(head)); // true
        System.out.println(isBinarySearchTree2(head)); // true
    }
}
