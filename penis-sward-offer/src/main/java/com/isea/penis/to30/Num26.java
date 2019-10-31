package com.isea.penis.to30;

/**
 * @author isea_you
 * @date 2019/10/31
 * @time 8:40
 * @target: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Num26 {
    private static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public TreeNode Convert(TreeNode root){
        // 递归终止条件
        if (root == null){
            return null;
        }
        if (root.left == null && root.right ==  null){
            return root;
        }

        // 将左子树构建成双链表，并返回头节点
        TreeNode left = Convert(root.left);

        // 定位左子树双链表的最后一个节点
        TreeNode cur = left;
        while(cur != null && cur.right != null){
            cur = cur.right;
        }

        // 如果左子树链表不为为空的话，将当前root追加到左子树链表
        if (left != null){
            cur.right = root;
            root.left = cur;
        }

        // 将右子树转为双链表，并返回头节点
        TreeNode right = Convert(root.right);

        // 如果右子树链表不为空，追加到root
        if (right != null){
            root.right = right;
            right.left = root;
        }

        // 返回结果
        return left != null ? left : root;
    }
    public static void main(String[] args) {
        Num26 num26 = new Num26();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        TreeNode head = num26.Convert(root);
        TreeNode cur = head;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }
}
