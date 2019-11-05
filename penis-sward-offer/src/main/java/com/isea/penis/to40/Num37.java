package com.isea.penis.to40;

/**
 * @author isea_you
 * @date 2019/11/5
 * @time 13:23
 * @target:  统计一个数字在排序数组中出现的次数。
 */
public class Num37 {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length < 1){
            return 0;
        }
        int res = 0;
        int i = 0;
        while(i < array.length && array[i] <= k ){
            if (array[i] == k){
                res ++;
            }
            i ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Num37 num37 = new Num37();
        int[] arr = {1,2,3,4,6,6,6,7,8,9,10};

        System.out.println(num37.GetNumberOfK(arr, 1));
        System.out.println(num37.GetNumberOfK(arr, 6));
        System.out.println(num37.GetNumberOfK(arr, 10));// 0-10
    }
}
