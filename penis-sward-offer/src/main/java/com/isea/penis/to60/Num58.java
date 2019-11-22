package com.isea.penis.to60;

/**
 * @author isea_you
 * @date 2019/11/21
 * @time 18:07
 * @target: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Num58 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    // 求一颗树的后继节点，（后继节点也就是中序排序的时候，下一个节点的位置）
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }
        
        // 如果一颗树有右子树，右子树最左边的节点即为当前节点的后继
        if (pNode.right != null){
            return getLeftMost(pNode.right);
        }else {
            TreeLinkNode parent = pNode.next;
            // 如果当前节点是父节点的左子树，那么父节点即为所查节点的后继
            while(parent != null && parent.left != pNode){
                pNode = parent;
                parent = pNode.next;
            }
            return parent; // parent != null 最后一个节点的后继是null
        }
    }

    private TreeLinkNode getLeftMost(TreeLinkNode node) {
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(6);
        head.next = null;
        head.left = new TreeLinkNode(3);
        head.left.next = head;
        head.left.left = new TreeLinkNode(1);
        head.left.left.next = head.left;
        head.left.left.right = new TreeLinkNode(2);
        head.left.left.right.next = head.left.left;
        head.left.right = new TreeLinkNode(4);
        head.left.right.next = head.left;
        head.left.right.right = new TreeLinkNode(5);
        head.left.right.right.next = head.left.right;
        head.right = new TreeLinkNode(9);
        head.right.next = head;
        head.right.left = new TreeLinkNode(8);
        head.right.left.next = head.right;
        head.right.left.left = new TreeLinkNode(7);
        head.right.left.left.next = head.right.left;
        head.right.right = new TreeLinkNode(10);
        head.right.right.next = head.right;

        Num58 num58 = new Num58();
        System.out.println(num58.GetNext(head.left.left).val); // 应该是2
        System.out.println(num58.GetNext(head.left.right.right).val); // 应该是6
        System.out.println(num58.GetNext(head.right.right).val); // null
    }
}
