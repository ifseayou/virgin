package com.isea.clitoris.search;

/**
 * @author isea_you
 * @date 2019/8/23
 * @time 9:12
 * @target: 简单的二分查找，假设有序数组中不存在重复的元素
 */
public class BinarySearch {
    // 返回数据对应的下标
    public static int binarySearch(int[] arr,int value){
        if (arr.length <= 0 || arr == null){
            return -1;
        }
        int high = arr.length - 1;
        int low = 0;
        while(low <= high){
            int middle = low + (high - low) / 2;
            if (arr[middle] == value){
                return middle;
            }else if (arr[middle] < value){
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9};
        System.out.println(binarySearch(arr, 3));
    }
}
