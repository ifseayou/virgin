package com.isea.penis.to30;

/**
 * @author isea_you
 * @date 2019/10/29
 * @time 8:08
 * @arget: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Num23 {
    public boolean VerifySequenceOfBST(int[] sequence) {
        // 如果序列的长度为0，不认为是二叉搜索树
        if (sequence.length == 0 || sequence == null) {
            return false;
        }

        // 判断从start 到 end位置是否为BST
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        // 如果end = start 认为是
        if (end == start) {
            return true;
        }
        // 从start开始，判断左子树是否都是小于根的
        int i = start;
        while (i < end) {
            if (sequence[i] > sequence[end]) {
                break;
            }
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]){
                return false;
            }
        }

        return isBST(sequence,start,i - 1) && isBST(sequence,i,end - 1);
    }

    public static void main(String[] args) {
        Num23 num23 = new Num23();
        int[] sequence1 = {1, 3, 2, 5, 7, 6, 4};
        int[] sequence2 = {1, 100, 2, 5, 7, 6, 4};

        System.out.println(num23.VerifySequenceOfBST(sequence1));
        System.out.println(num23.VerifySequenceOfBST(sequence2));

    }
}
