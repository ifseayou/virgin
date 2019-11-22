package com.isea.penis.to40;

/**
 * @author isea_you
 * @date 2019/11/5
 * @time 11:39
 * @target: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 也即修逆序对的总对数
 */
public class Num35 {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 1){
            return -1;
        }
        return mergeSort(array,0,array.length - 1);
    }

    private int mergeSort(int[] array, int L, int R) {
        if (L == R){
            return 0;
        }
        int middle = L + ((R - L ) >> 1);
        int count = mergeSort(array,L,middle)// 左边逆序对的个数       分治
                + mergeSort(array,middle + 1,R) //右边逆序对的个数  分治
                + merge(array,L,middle,R);// 合并时逆序对的个数        迭代
        return count % 1000000007;
    }

    private int merge(int[] array, int L, int middle, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = middle + 1;
        int res = 0;
        int i = 0;
        while(p1 <= middle && p2 <= R){
            res += array[p1] > array[p2] ? middle - p1 + 1 : 0;
            help[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while(p1 <= middle){
            help[i ++] = array[p1++];
        }
        while(p2 <= R){
            help[i ++] = array[p2 ++];
        }
        for (i = 0 ; i < help.length ; i ++){
            array[L + i] = help[i];
        }
        return res % 1000000007;
    }
}
