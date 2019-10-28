package com.isea.penis.to10;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 13:09
 * @target: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * !!! 注意这里已经强调过了没有重复的数字
 */
public class Num4 {
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
        // 如果要测试测试，需要遍历二叉树（先序，中序），检查是否是原来的数组的顺序，这里不在给出代码
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
         return reConstructBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre,int preL,int preR,int[] in,int inL,int inR){
        if (preL > preR || inL > inL){
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[preL]){
                root.left = reConstructBinaryTree(pre,preL + 1,preL + i - inL,in,inL,i - 1);
                root.right = reConstructBinaryTree(pre,preL + i - inL + 1,preR,in,i + 1,inR);
                break;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Num4 num4 = new Num4();
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        System.out.println(num4.reConstructBinaryTree(pre, in));
    }

}
