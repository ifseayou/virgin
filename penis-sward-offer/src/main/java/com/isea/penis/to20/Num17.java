package com.isea.penis.to20;

/**
 * @author isea_you
 * @date 2019/10/26
 * @time 19:11
 * @target: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * !!!
 */
public class Num17 {
    public static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if (root1 != null && root2 != null){
            if (root1.value == root2.value){
                flag = doesTree1HasTree2(root1,root2);
            }
            if (!flag){
                flag = HasSubtree(root1.left,root2);
            }
            if (!flag){
                flag = HasSubtree(root1.right,root2);
            }
        }
        return flag;
    }

    private boolean doesTree1HasTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null){
            return true;
        }
        if (node1 == null){
            return false;
        }
        if (node1.value != node2.value){
            return false;
        }
        return doesTree1HasTree2(node1.left,node2.left) && doesTree1HasTree2(node1.right,node2.right);
    }


    public static void main(String[] args) {
        Num17 num17 = new Num17();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        System.out.println(num17.HasSubtree(root1, root2));
    }
}
