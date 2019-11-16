package com.isea.penis.to70;

import java.util.LinkedList;

/**
 * @author isea_you
 * @date 2019/11/16
 * @time 8:28
 * @target: 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Num62 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 以先序的方式序列化一颗树
    String Serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return res.append("#_").toString();
        }
        // 序列化头节点
        res.append(root.val + "_");
        // 序列化左子树
        res.append(Serialize(root.left));
        // 序列化右子树
        res.append(Serialize(root.right));
        return res.toString();
    }

    // 反序列化一棵树
    TreeNode Deserialize(String str) {
        LinkedList<String> queue = new LinkedList<>();
        String[] nodes = str.split("_");
        for (String node : nodes) {
            queue.offer(node); // Adds the specified element as the tail (last element) of this list.
        }
        return deSerialBinaryTree(queue);
    }

    private TreeNode deSerialBinaryTree(LinkedList<String> queue) {
        String value = queue.poll();// Retrieves and removes the head (first element) of this list.
        if ("#".equals(value)){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = deSerialBinaryTree(queue);
        head.right = deSerialBinaryTree(queue);
        return head;
    }


    public static void main(String[] args) {
        Num62 num62 = new Num62();
        TreeNode head = null;
        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        System.out.println(num62.Serialize(head));
    }
}
