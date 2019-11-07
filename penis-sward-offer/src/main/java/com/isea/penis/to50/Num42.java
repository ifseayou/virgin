package com.isea.penis.to50;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/11/6
 * @time 12:38
 * @target: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Num42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = array.length - 1;
        int j = array.length - 1;
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int help = array[left] + array[right];
            if (help == sum){
                if (help < array[i] * array[j]){
                    i = left;
                    j = right;
                }
                right --;
            }else if (help < sum){
                left ++;
            }else {
                right --;
            }
        }
        if (i == j){
            return res;
        }else {
            res.add(array[i]);
            res.add(array[j]);
            return res;
        }
    }
    public static void main(String[] args) {
        Num42 num42 = new Num42();

        int[] arr2 = {1,2,4,7,11,16};
        ArrayList<Integer> res2 = num42.FindNumbersWithSum(arr2, 10);
        if (res2 != null){
            res2.forEach(t-> System.out.print(t + " "));
        }

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> res = num42.FindNumbersWithSum(arr, 10);
        res.forEach(t-> System.out.print(t + " "));

    }
}
