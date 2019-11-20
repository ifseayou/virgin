package com.isea.penis.to70;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/11/19
 * @time 12:56
 * @target: 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4。
 */
public class Num63 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    TreeNode KthNode(TreeNode pRoot, int k) {
        ArrayList<TreeNode> res = new ArrayList<>();
        inOrder(pRoot, res);
        if (k > res.size() || k == 0) {
            return null;
        }
        return res.get(k - 1);
    }

    private ArrayList<TreeNode> inOrder(TreeNode root, ArrayList<TreeNode> res) {
        if (root == null) {
            return null;
        }
        inOrder(root.left, res); // 左
        res.add(root); // 当前节点
        inOrder(root.right, res); // 右
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        Num63 num63 = new Num63();
        System.out.println(num63.KthNode(root, 3).val);

//        for (TreeNode re : res) {
//            System.out.print(re.val + "\t");
//        }
//        System.out.println(num63.KthNode(root, 3).val);
        System.out.println(num63.KthNode(root, 8).val);
    }
}
