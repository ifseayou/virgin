package com.isea.penis.to30;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author isea_you
 * @date 2019/10/28
 * @time 18:08
 * @target: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。即为二叉树的层序遍历
 */
public class Num22 {
    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> help = new LinkedList<>();
        help.addLast(root);
        while (!help.isEmpty()) {
            TreeNode cur = help.pop();
            res.add(cur.value);
            if (cur.left != null) {
                help.addLast(cur.left);
            }
            if (cur.right != null) {
                help.addLast(cur.right);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Num22 num22 = new Num22();
        ArrayList<Integer> res = num22.PrintFromTopToBottom(root);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
