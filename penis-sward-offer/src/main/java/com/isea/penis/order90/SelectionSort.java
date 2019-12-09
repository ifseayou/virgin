package com.isea.penis.order90;

import com.isea.penis.utils.Swap;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 8:26
 * @target:
 */
public class SelectionSort {
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0;i < arr.length - 1; i ++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j ++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            Swap.swap2(arr,i,minIndex);
        }
    }
}
