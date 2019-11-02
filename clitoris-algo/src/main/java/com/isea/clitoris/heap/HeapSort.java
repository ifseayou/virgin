package com.isea.clitoris.heap;

/**
 * 堆排序：这里构建大根堆，堆排序的主要操作是
 * heapInsert，也即将一个元素加入到堆中，使得结构仍然是堆的结构,这是一个上浮的过程
 * heapify，也即如果一个元素发生了变化，这个元素进行下沉的过程
 */
class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr ==  null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); // 堆化的过程，将一个数组组织成为堆的结构
        }
        int heapSize = arr.length; // heapSize 就是堆的大小
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);// 保持堆的结构，下沉的过程
            swap(arr, 0, --heapSize);
        }
    }

    // 在arr中，认为[0,heapSize-1]位置形成了堆结构
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largestIndex = left + 1 < heapSize && arr[left] < arr[left + 1] ?
                    left + 1 :
                    left;
            largestIndex = arr[index] > arr[largestIndex] ? index : largestIndex;
            if (largestIndex == index) {
                break;
            }
            swap(arr, index, largestIndex);
            index = largestIndex; // 当前下标变为较大的孩子的下标，left变化继续循环。
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { // 当前的节点小于父，或者是等于父，都不会继续进行下去了
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
