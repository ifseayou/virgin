package com.isea.penis.recursion;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 9:03
 * @target: 认识递归，求最大值，然后分析栈结构的过程
 */
public class RecursionSample {
    public int getMax(int[] arr){
        if (arr == null || arr.length < 1){
            return -1;
        }
        return getMax(arr,0,arr.length -1);
    }

    private int getMax(int[] arr,int L , int R){
        if (L == R){
            return arr[L];
        }
        int middle = L + (R - L) / 2;
        int leftMax = getMax(arr, L, middle);
        int rightMax = getMax(arr, middle + 1, R);
        return Math.max(leftMax,rightMax);
    }
}
