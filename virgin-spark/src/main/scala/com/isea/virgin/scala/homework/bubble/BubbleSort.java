package com.isea.virgin.scala.homework.bubble;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    /**
     * 冒泡排序，然后使用对数器来验证该排序的算法是否正确
     *
     * @param args
     */
    public static void main(String[] args) {
        // 产生一个随机长度，随机数值的数组，长度在1-100之内，随机数在-100~ 100 之内
        int[] arr1 = genRandomArray(100, 100);

        // 拷贝数组
        int[] arr2 = copyArray(arr1);

        // 对arr1，和arr2 分别用自己写的排序算法和绝对正确的排序算法排序，检查排序之后的arr1 和 arr2 的值是否相等
        rightSort(arr1);
        bubbleSort(arr2);
        boolean result = isEqual(arr1, arr2);
        if (result) {
            System.out.println("Right....");
        } else {
            System.out.println("Error....");
        }

        // 随机一个数组排序，然后在查看一下排序的效果
        arr1 = genRandomArray(100, 100);
        printArray(arr1);
        bubbleSort(arr1);
        printArray(arr1);
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * @param maxSize  随机数组的长度
     * @param maxValue 随机数组的数值范围
     * @return 返回一个随机长度随机值的int类型的数组
     */
    public static int[] genRandomArray(int maxSize, int maxValue) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("随机数组的长度必须大于0");
        }
        int[] arr = new int[new Random().nextInt(maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (new Random().nextInt(maxSize) + 1) - (new Random().nextInt(maxSize) + 1);
        }
        return arr;
    }

    /**
     * 绝对正确的排序方法
     *
     * @param arr
     */
    public static void rightSort(int[] arr) {
        Arrays.sort(arr);
    }


    /**
     * 检查两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        } else if (arr1 == null && arr2 != null) {
            return false;
        } else if (arr1 != null && arr2 == null) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组的拷贝
     *
     * @param arr
     * @return
     */
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("The array is empty...");
        }
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
