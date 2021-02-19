package com.isea.clitoris.search;

/**
 * @author isea_you
 * @date 2019/8/23
 * @time 9:12
 * @target:
 */
public class BinarySearch {
    // 返回数据对应的下标

    /**
     * 简单的二分查找，假设有序数组中不存在重复的元素
     * @param arr
     * @param value
     * @return
     */
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

    /**
     * 查找第一个值等于给定值的元素
     */
    public static int binarySearch2(int[] arr,int value){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = low +(high - low)>>1;
            if (arr[mid] > value){
                high = mid -1;
            }else if (arr[mid] < value){
                low = mid + 1;
            }else {
                if (mid == 0 || arr[mid -1] !=value){
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public static int binarySearch5(int[] arr,int value){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = low +(high - low)>>1;
            if (arr[mid] > value){
                high = mid -1;
            }else if (arr[mid] < value){
                low = mid + 1;
            }else {
                if (mid == arr.length -1 || arr[mid +1] != value){
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public static int binarySearch6(int[] arr,int value){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = low +(high - low)>>1;
            if (arr[mid] >= value){
                if (mid != 0 || arr[mid - 1] < value){
                    return mid;
                }else {
                    high = mid -1;
                }
            }else {
             low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public static int binarySearch7(int[] arr,int value){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = low +(high - low)>>1;
            if (arr[mid] <= value){
                if (mid == arr.length -1 || arr[mid + 1] > value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    /**
     * 二分递归实现
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch3(int[] arr,int value){
        return bSearch(arr,0,arr.length -1,value);
    }

    private static int bSearch(int[] arr, int low, int high, int value) {
        if (low > high){
            return -1;
        }
        int mid = low + (high - low) >> 1;
        if (arr[mid] == value){
            return mid;
        }else if (arr[mid] > value){
            return bSearch(arr,low,mid -1,value);
        }else {
            return bSearch(arr,mid + 1,high,value);
        }
    }




    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9};
        System.out.println(binarySearch(arr, 3));
    }
}
