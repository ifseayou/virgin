package com.isea.penis.to60;

/**
 * @author isea_you
 * @date 2019/11/20
 * @time 18:02
 * @target: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Num59 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        return isCommon(pRoot.left,pRoot.right);
    }

    private boolean isCommon(TreeNode left, TreeNode right) {
        if (left == null){
            return right == null;
        }
        if (right == null){
            return false;
        }
        if (right.val != left.val){
            return false;
        }
        return isCommon(left.left,right.right) && isCommon(left.right,right.left);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left = new TreeNode(3);

        Num59 num59 = new Num59();
        System.out.println(num59.isSymmetrical(root1));
        System.out.println(num59.isSymmetrical(null));
        System.out.println(num59.isSymmetrical(root2));
    }
}
