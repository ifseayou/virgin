package com.isea.penis;

import com.isea.penis.order90.*;
import org.junit.Test;

import static com.isea.penis.utils.OrderChecker.*;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 8:18
 * @target:
 */
public class Order100Test {
    @Test
    public void testBubbleSort(){
        BubbleSort bs = new BubbleSort();
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bs.bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bs.bubbleSort(arr);
        printArray(arr);
    }

    @Test
    public void testSelectionSort(){
        SelectionSort ss = new SelectionSort();
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            ss.selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        ss.selectionSort(arr);
        printArray(arr);
    }

    @Test
    public void testInsertSort(){
        InsertSort is = new InsertSort();
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            is.insertSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        is.insertSort(arr);
        printArray(arr);
    }

    @Test
    public void testMergeSort(){
        MergeSort ms = new MergeSort();
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            ms.mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        ms.mergeSort(arr);
        printArray(arr);
    }

    @Test
    public void testQuickSort(){
        QuickSort qs = new QuickSort();
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            qs.quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        qs.quickSort(arr);
        printArray(arr);
    }
}
