package com.isea.penis.to30;

import java.util.ArrayList;

/**
 * @author isea_you
 * @date 2019/11/1
 * @time 19:45
 * @target: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。如果那个
 * !!! 可以直接对数组排序，但是时间复杂度是O（N * logN） ； 如果维护一个堆结构的话，时间复杂度为：O（N * logK）
 */
public class Num29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 如果k小于0，或者是k大于数组的长度，直接返回数组
        ArrayList<Integer> re = new ArrayList<>();
        if (k < 1 || input.length < k) {
            return re;  // k大于的情况，返回空数组
        }

        // 创建长度为K的数组，并将该数组构建成一个大根堆，根是k个数中最大的元素
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, input[i], i);
        }

        // 从k位置开始，遍历数组中剩余的元素，如果比堆顶的元素还大，进行交换，并且维护堆的结构heapify过程
        for (int i = k; i != input.length; i++) {
            if (input[i] < kHeap[0]) {
                kHeap[0] = input[i];
                heapify(kHeap, 0, k);// k始终是堆的大小,0表示的是index，当前位置
            }
        }

        // 返回堆即为我们求的结果
        for (int i : kHeap) {
            re.add(i);
        }
        return re;
    }

    private void heapify(int[] kHeap, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largestIndex = left + 1 < heapSize && kHeap[left + 1] > kHeap[left] ?
                    left + 1 :
                    left;
            largestIndex = kHeap[index] > kHeap[largestIndex] ? index : largestIndex;
            if (largestIndex == index) {
                break;
            }
            swap(kHeap,index,largestIndex);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (arr[index] > arr[(index - 1) / 2]) {  // (index - 1) / 2
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] arr, int index, int j) {
        int tmp = arr[index];
        arr[index] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Num29 num29 = new Num29();
        int[] inputs = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = num29.GetLeastNumbers_Solution(inputs, 4);
        res.forEach((i) ->
                System.out.print(i + " "));
    }
}
