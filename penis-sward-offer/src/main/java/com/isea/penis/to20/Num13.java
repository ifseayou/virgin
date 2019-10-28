package com.isea.penis.to20;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/10/24
 * @time 10:37
 * @target: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *  所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Num13 {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i : array) {
            if (i % 2 != 0){
                arr1.add(i);
            }else {
                arr2.add(i);
            }
        }
       arr1.addAll(arr2);
        for (int i = 0; i < array.length; i++) {
            array[i] = arr1.get(i);
        }
    }
    public static void main(String[] args) {
        int[] array = {4,5,3,2,1,6};
        for (int i : array) {
            System.out.print(i + "\t");
        }
        Num13 num13 = new Num13();
        num13.reOrderArray(array);
        System.out.println();
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}
