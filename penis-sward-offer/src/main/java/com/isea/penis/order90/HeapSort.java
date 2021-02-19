package com.isea.penis.order90;

import com.isea.penis.utils.Swap;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/11 9:03
 * @target:
 */
public class HeapSort {
    public void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        // 建立大根堆
        for (int i = 0;i < arr.length ; i ++){
            heapInsert(arr,i);
        }

        // 进行堆排序
        int heapSize = arr.length; // 堆的大小
        Swap.swap2(arr,0,--heapSize); // 对调堆顶的元素和数组的最后一个元素
        while(heapSize > 0){
            heapify(arr,0,heapSize); // 调整堆的结构
            Swap.swap2(arr,0,--heapSize);
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while(left < heapSize){ // 在堆的范围内
            int largestIndex = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largestIndex = arr[index] > arr[largestIndex] ? index : largestIndex;
            if (index == largestIndex){
                break; // 跳出循环，表示当前位置即为该元素在堆中的位置
            }
            Swap.swap2(arr,index,largestIndex);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index -1) / 2]){
            Swap.swap2(arr,index,(index -1) / 2);
            index = (index - 1) / 2;
        }
    }
}
