package com.isea.penis.end80;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 15:46
 * @target: 如果一个数组中，左边的数比右边的数大，则两个数构成一个逆序对，请打印所有的逆序对
 * 打印所有的逆序对
 */
public class Num74 {
    public void reverseOrderPair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int middle = L + ((R - L) >> 1);
        sortProcess(arr, L, middle);
        sortProcess(arr, middle + 1, R);
        merge(arr, L, middle, R);
    }

    private void merge(int[] arr, int L, int middle, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = middle + 1;
        int i = 0;
        while (p1 <= middle && p2 <= R) {
            if (arr[p1] > arr[p2]){ // 从[p1,middle]范围内的所有数都和arr[p2]构成逆序对
                for (int j = p1; j <= middle; j ++){
                    System.out.print( "["+ arr[j] + ":" + arr[p2] +"]" + "\t");
                }
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
