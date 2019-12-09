package com.isea.penis.order90;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 14:41
 * @target:
 */
public class MergeSort {
    public void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        sortProcess(arr,0,arr.length -1);
    }

    private void sortProcess(int[] arr, int L, int R) {
        if (L == R){
            return;
        }

        int middle = L + (R - L ) / 2;
        sortProcess(arr,L,middle);
        sortProcess(arr,middle + 1,R);
        merge(arr,L,middle,R);
    }

    private void merge(int[] arr, int L, int middle, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = middle + 1;
        int i = 0;
        while(p1 <= middle && p2 <= R){
            help[i ++] = arr[p1] < arr[p2] ? arr[p1 ++] : arr[p2 ++];
        }
        while(p1 <= middle){
            help[i ++] = arr[p1 ++];
        }
        while(p2 <= R){
            help[i ++] = arr[p2 ++];
        }
        for (i = 0 ; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }
}
