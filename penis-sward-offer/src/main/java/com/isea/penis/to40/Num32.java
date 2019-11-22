package com.isea.penis.to40;

import java.util.Arrays;

/**
 * @author isea_you
 * @date 2019/11/2
 * @time 14:09
 * @target: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Num32 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strArr = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, (a, b) -> {
            String x = a + b;
            String y = b + a;
            return x.compareTo(y);
        });
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
