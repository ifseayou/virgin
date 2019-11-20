package com.isea.penis.to70;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author isea_you
 * @date 2019/11/20
 * @time 15:15
 * @target: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Num61 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = pRoot;
        TreeNode nLast = null;
        queue.offer(pRoot);
        ArrayList<Integer> res1 = new ArrayList<>();
        while(!queue.isEmpty()){
            pRoot = queue.poll();
            if (pRoot.left != null){
                nLast = pRoot.left;
                queue.offer(pRoot.left);
            }
            if (pRoot.right != null){
                nLast = pRoot.right;
                queue.offer(pRoot.right);
            }
            res1.add(pRoot.val);
            if (last == pRoot){
                last = nLast;
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
        Num61 num61 = new Num61();
        ArrayList<ArrayList<Integer>> res = num61.Print(root);
        res.forEach(t -> {
            t.forEach(x -> System.out.print(x + "\t"));
            System.out.println();
        });
    }
}
