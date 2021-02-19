package com.isea.learn.practice;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/15 9:35
 * @target:
 */
public class Video {
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return sortProcess(arr,0,arr.length-1);
    }

    private static int sortProcess(int[] arr, int L, int R) {
        if (L == R){
            return 0;
        }
        int middle = L + (R - L)/2;
        return sortProcess(arr,L,middle) +
                sortProcess(arr,middle+1,R)+
                merge(arr,L,middle,R);
    }

    private static int merge(int[] arr, int L, int middle, int R) {
        int[] help = new int[R - L +1];
        int p1 = L;
        int p2 = middle +1;
        int res = 0;
        int i = 0;
        while(p1<=middle && p2 <= R){
            res = arr[p1] < arr[p2]?arr[p1]*(R-L+1):0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1]:arr[p2];
        }
        while(p1<= middle){
            help[i++] = arr[p1++];
        }
        while(p2<= middle){
            help[i++] = arr[p2++];
        }
        for (i =0;i<help.length;i++){
            arr[L+i] = help[i];
        }
        return res;
    }

    public static int[] netherlandsFlag(int[] arr,int L,int R,int num){
        int less = L -1;
        int more = R + 1;
        while(L < more){
            if (arr[L] < num){
                swap(arr,++less,L++);
            }else if(arr[L] > num){
                swap(arr,--more,L);
            }else{
                L ++;
            }
        }
        return new int[]{less +1,more-1 };

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
