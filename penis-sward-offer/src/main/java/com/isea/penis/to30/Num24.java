package com.isea.penis.to30;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/10/29
 * @time 8:39
 * @target: 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 */
public class Num24 {
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
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return res;
        }
        findPath(root,target);
        return res;
    }

    private void findPath(TreeNode root, int target) {
        //因为FindPath中和 下面程序中都进行了判null操作，root绝对不可能为 null
        path.add(root.value);
        //已经到达叶子节点，并且正好加出了target
        if (root.value == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        // 如果左子树非null，递归左子树
        if (root.left != null){
            findPath(root.left,target - root.value);
        }
        // 如果右子树为null，递归右子树
        if (root.right != null){
            findPath(root.right , target - root.value);
        }
        // 无论当前是否加出target元素，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null
        path.remove(path.size() - 1);
        return ;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        Num24 num24 = new Num24();
        ArrayList<ArrayList<Integer>> res = num24.FindPath(root, 8);
        res.forEach(list ->{
            for (Integer i : list) {
                System.out.print( i + " ");
            }
            System.out.println();
        });
    }
}
