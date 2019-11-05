package com.isea.penis.to40;

/**
 * @author isea_you
 * @date 2019/11/5
 * @time 14:04
 * @target: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Num38 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode root) {
        return getTreeDepth(root);
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null){
            return  0;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;
    }

    public static void main(String[] args) {
        Num38 num38 = new Num38();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        System.out.println(num38.TreeDepth(root));
    }
}
