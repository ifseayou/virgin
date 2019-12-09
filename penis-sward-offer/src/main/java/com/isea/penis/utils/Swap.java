package com.isea.penis.utils;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 8:45
 * @target:
 */
public class Swap {
    public static void swap1(int[] arr,int i ,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap2(int[] arr,int i ,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
