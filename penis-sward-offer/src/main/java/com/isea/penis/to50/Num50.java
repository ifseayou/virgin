package com.isea.penis.to50;

import java.util.HashMap;

/**
 * @author isea_you
 * @date 2019/11/15
 * @time 7:36
 * @target: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *     duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
 *     这里要特别注意~返回任意重复的一个，赋值duplication[0]
 *     Return value:       true if the input is valid, and there are some duplications in the array number
 *                         otherwise false
 */
public class Num50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer, Integer> help = new HashMap<>();
        duplication[0] = -1;
        for (int i = 0; i < length ; i ++){
            if (!help.containsKey(numbers[i])){
                help.put(numbers[i],1);
            }else {
                duplication[0] = numbers[i];
                break;
            }
        }
        return duplication[0] == -1 ? false : true;
    }

    public static void main(String[] args) {
        Num50 num50 = new Num50();
        int[] arr1 = {2,3,1,0,2,5,3};
        int[] dup1 = new int[1];
        System.out.println(num50.duplicate(arr1,arr1.length,dup1));
        System.out.println(dup1[0]);

        int[] arr2 = {2,3,1};
        int[] dup2 = new int[1];
        System.out.println(num50.duplicate(arr2,arr2.length,dup2));
        System.out.println(dup2[0]);

        int[] arr3 = {};
        int[] dup3 = new int[1];
        System.out.println(num50.duplicate(arr3,arr3.length,dup3));
        System.out.println(dup3[0]);
    }

}
