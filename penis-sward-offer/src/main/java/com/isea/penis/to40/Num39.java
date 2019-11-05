package com.isea.penis.to40;



/**
 * @author isea_you
 * @date 2019/11/5
 * @time 15:28
 * @target: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 本质是一个树形DP的过程，判断左子树是否是一颗平衡二叉树，在判断右子树是否是一个平衡二叉树
 * 最后在判断整体是否是一颗平衡二叉树，判断的函数要返回相同的结构
 */
public class Num39 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    private static class ReturnData{
        private boolean isB;
        private int h;
        public ReturnData(boolean isB ,int h){
            this.isB = isB;
            this.h = h;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {

        return process(root).isB;
    }

    // 判断一颗以node为根节点的树是否是平衡二叉树，如果是，返回当前（以node为根）的高度
    private ReturnData process(TreeNode node) {
        if (node == null){
            return new ReturnData(true,0);
        }

        // 判断左树是否是一颗平衡二叉树
        ReturnData left = process(node.left);
        if (!left.isB){
            return new ReturnData(false,0); // 如果左子树不是平衡的，高度没有意义了，返回的全都是0
        }

        // 判断右树是否是一颗平衡二叉树
        ReturnData right = process(node.right);
        if (!right.isB){
            return new ReturnData(false,0);
        }

        // 判断当前节点是否是一颗平衡二叉树
        if (Math.abs(left.h - right.h) > 1){
            return new ReturnData(false,0);
        }

        return new ReturnData(true,Math.max(left.h,right.h) + 1);
    }

    public static void main(String[] args) {
        Num39 num39 = new Num39();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        System.out.println(num39.IsBalanced_Solution(root));
    }
}
