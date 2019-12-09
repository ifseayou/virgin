package com.isea.penis.order90;

import java.util.Random;
import static com.isea.penis.utils.Swap.swap2;

/**
 * @author ifseayou@gmail.com
 * @date 2019/12/7 16:51
 * @target:
 */
public class QuickSort {
    public void quickSort(int[] arr){
        if ( arr.length < 2 ||  arr == null ){
            return;
        }
        sortProcess(arr,0, arr.length - 1);
    }

    private void sortProcess(int[] arr, int L, int R) {
        if(L < R){
            // 随机一个位置到数组的最后个元素
            swap2(arr,(L + new Random().nextInt(R - L + 1)),R);
            // partition
            int[] p = partition(arr,L,R);
            sortProcess(arr,L,p[0] -1);
            sortProcess(arr,p[1] + 1,R);
        }
    }

    private int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while(L < more){
            if (arr[L] < arr[R]){
                swap2(arr, ++less,L++);
            }else if (arr[L] > arr[R]){
                swap2(arr,--more,L);
            }else {
                L ++;
            }
        }
        swap2(arr,R,more);
        return new int[]{less + 1,more};
    }
}
