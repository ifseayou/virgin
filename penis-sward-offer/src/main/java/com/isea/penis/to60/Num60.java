package com.isea.penis.to60;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author isea_you
 * @date 2019/11/16
 * @time 8:28
 * @target: 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Num60 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> dQueue = new LinkedList<>();//  双端对列
        boolean l2r = true; // 默认从左往右开始打印
        TreeNode last = pRoot; // 最后一个节点
        TreeNode nLast = null; // 记录每行最后一个节点
        dQueue.offerFirst(pRoot);
        ArrayList<Integer> res1 = new ArrayList<>();
        while (!dQueue.isEmpty()) { // 在dQueue非空的情况下，不断进行循环
            if (l2r) { // 如果是从左往右
                pRoot = dQueue.pollFirst();
                if (pRoot.left != null) {
                    nLast = nLast == null ? pRoot.left : nLast; // 不为null表示是第一次入队列，也即左右切换的时机
                    dQueue.offerLast(pRoot.left);
                }
                if (pRoot.right != null) {
                    nLast = nLast == null ? pRoot.right : nLast;
                    dQueue.offerLast(pRoot.right);
                }
            } else { // 从右往左
                pRoot = dQueue.pollLast();
                if (pRoot.right != null) {
                    nLast = nLast == null ? pRoot.right : nLast;
                    dQueue.offerFirst(pRoot.right);
                }
                if (pRoot.left != null) {
                    nLast = nLast == null ? pRoot.left : nLast;
                    dQueue.offerFirst(pRoot.left);
                }
            }
            res1.add(pRoot.val);
            if (pRoot == last ) { // 判断左右的切换
                l2r = !l2r;
                last = nLast; // 当前行的最后一个节点
                nLast = null;
                res.add(res1);
                res1 = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        Num60 num60 = new Num60();
        ArrayList<ArrayList<Integer>> res = num60.Print(root);
        res.forEach(t -> {
            t.forEach(x -> System.out.print(x + "\t"));
            System.out.println();
        });
    }
}
