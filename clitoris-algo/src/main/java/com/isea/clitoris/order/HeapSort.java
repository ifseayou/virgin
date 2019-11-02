package com.isea.clitoris.order;

/**
 * @author isea_you
 * @date 2019/11/2
 * @time 8:45
 * @target: 利用堆结构实现一个数组的排序，时间复杂度：O（N * logN）
 */
class HeapSort {

    public void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 将一个数组堆化，此时建立一个大根堆
        for (int i = 0; i < arr.length ; i ++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length; // 堆的大小，[0,heapSize-1] 位置形成了堆
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        // 当前index节点的左孩子
        int left = index * 2 + 1;
        while(left < heapSize){ // 还在堆的范围内
            int lagestIndex = left  + 1 < heapSize && arr[left + 1] > arr[left] ?
                    left + 1:
                    left;
            lagestIndex = arr[index] > arr[lagestIndex] ? index : lagestIndex;
            if (index == lagestIndex){
                break;
            }
            swap(arr,index ,lagestIndex);
            index = lagestIndex;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] arr, int i) {
        while(arr[i] > arr[(i - 1) / 2]){
            swap(arr,i,(i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,9,10};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
