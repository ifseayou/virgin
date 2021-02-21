package com.isea.clitoris.tree.judge;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/21 10:35
 * @target:
 * 判断是否是平衡二叉树
 * 本质是一个树形DP的过程，判断左子树是否是一颗平衡二叉树，在判断右子树是否是一个平衡二叉树
 * 最后在判断整体是否是一颗平衡二叉树，判断的函数要返回相同的结构
 */
public class IsBalanceTree {
    private static class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }

    }
    private static class ReturnData {
        private boolean isB;
        private int h;
        public ReturnData(boolean isB, int h){
            this.isB = isB;
            this.h = h;
        }
    }

    private static boolean isB(TreeNode head) {
        return processB(head).isB;
    }

    private static ReturnData processB(TreeNode head) {
        if (head == null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = processB(head.left);
        if(!leftData.isB) return new ReturnData(false,0);
        ReturnData rightData = processB(head.right);
        if(!rightData.isB) return new ReturnData(false,0);
        if(Math.abs(leftData.h - rightData.h) > 2) return new ReturnData(false,0);
        return new ReturnData(true,Math.max(leftData.h,rightData.h) + 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(isB(head)); // true
    }
}
