package com.isea.penis.end80;

/**
 * @author isea_you
 * @date 2019/11/22
 * @time 14:01
 * @target: 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 * 方法1：遍历每个数，查看每个数之前的数是不是比当前位置小 O（N ^ 2）的时间复杂度，对数器的方法
 * 方法2：使用归并排序的逻辑来解
 *
 * 和小和问题相似的还有逆序对问题(Num74)
 */
public class Num71 {
    public int smallSum(int[] arr) {
        if (arr == null || arr.length == 1) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    // 计算arr中 [l,r]范围内的小和
    private int mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int middle = L + ((R - L) >> 1);
        return mergeSort(arr, L, middle) // 左半部分的小和
                + mergeSort(arr, middle + 1, R) //  右半部分的小和
                + merge(arr, L, middle, R); // 合并的过程中的小和
    }

    private int merge(int[] arr, int L, int middle, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = middle + 1;
        int i = 0;
        int res = 0;
        while (p1 <= middle && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for ( i = 0 ; i < help.length ; i ++){
            arr[L + i] = help[i];
        }
        return res;
    }
}
