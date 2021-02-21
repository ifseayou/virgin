package com.isea.clitoris.tree.traverse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/21 10:09
 * @target: 序列化一颗树
 */
public class SerialBinaryTree {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    private static String serialByPre(TreeNode head) {
        if (head == null){
            return "#_";
        }
        String res = head.val + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
    private static TreeNode reconByPreStr(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconByPreStr(queue);
    }

    private static TreeNode reconByPreStr(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconByPreStr(queue);
        head.right = reconByPreStr(queue);
        return head;
    }


    public static void main(String[] args) {
        TreeNode head = null;
        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);

        System.out.println(serialByPre(head));
    }


}
