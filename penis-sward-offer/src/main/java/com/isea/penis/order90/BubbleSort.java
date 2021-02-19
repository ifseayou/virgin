package com.isea.penis.order90;

import com.isea.penis.utils.Swap;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 8:12
 * @target:
 */
public class BubbleSort {
    public void  bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1; end > 0 ; end --){
            for (int j = 0 ; j < end ; j ++){
                if (arr[j] > arr[j + 1]){
                    Swap.swap1(arr,j,j + 1);
                }
            }
        }
    }
}
