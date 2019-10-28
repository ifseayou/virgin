package com.isea.penis.to20;

/**
 * @author isea_you
 * @date 2019/10/27
 * @time 10:04
 * @target: 操作给定的二叉树，将其变换为源二叉树的镜像。
 *       源二叉树
 *  	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *  ！！！ 左边和右边调换，然后在递归左子树和右子树
 */
public class Num18 {
    private static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(){}
        private TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if (root != null){
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null){
                Mirror(root.left);
            }
            if (root.right != null){
                Mirror(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Num18 num18 = new Num18();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        num18.Mirror(root);
        System.out.print(root.left.value + "->" + root.value + "->" + root.right.value);
    }
}
