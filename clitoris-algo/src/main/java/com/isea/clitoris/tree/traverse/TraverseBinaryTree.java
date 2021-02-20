package com.isea.clitoris.tree.traverse;

/**
 * 遍历二叉树，前序，中序，后序的递归写法
 */
public class TraverseBinaryTree {
    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static void preOrder(Node node){
        if (node == null) return;
        System.out.print(node.data + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + "->");
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "->");
    }
}
