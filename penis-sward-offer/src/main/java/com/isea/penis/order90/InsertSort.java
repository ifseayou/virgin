package com.isea.penis.order90;

import com.isea.penis.utils.Swap;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 8:52
 * @target:
 */
public class InsertSort {
    public void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i ++){
            for (int j = i ; j > 0 ; j --){
                if (arr[j] < arr[j -1]){
                    Swap.swap2(arr,j,j - 1);
                }
            }
        }
    }
}
