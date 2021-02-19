package com.isea.learn.practice;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/15 15:28
 * @target:
 */
public class Play {
    public static void main(String[] args) {
        System.out.println((0-1)/2);
    }
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            System.out.println("forbidden...");
            swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2+ 1;
        while(left < heapSize){
            int largest = (left +1) < heapSize && arr[left +1] > arr[left]?
                    left+1:
                    left;
            largest = arr[index] > arr[largest]? index : largest;
            if (largest == index){
                break;
            }
            swap(arr,0,largest);
            index = largest;
            left = index * 2+1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while(arr[index] < arr[(index-1)/2 ]){
            swap(arr,index,(index - 1)/2);
            index = (index -1) /2;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
