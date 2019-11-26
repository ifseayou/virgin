package com.isea.penis.end80;

import java.util.HashSet;

/**
 * @author isea_you
 * @date 2019/11/26
 * @time 20:21
 * @target: String[] arr1 = {"112","wqw","2121"}; String[] arr2 = {"112","aad","ewqw"}; 打印出两个数组的交集，结果不能重复
 */
public class Num73 {
    public void printIntersection(String[] strArr1,String[] strArr2){
        HashSet<String> help1 = new HashSet<>();
        HashSet<String> help2 = new HashSet<>();
        for (String str : strArr1) {
            help1.add(str);
        }
        for (String str : strArr2) {
            if (help1.contains(str)){
                help2.add(str);
            }
        }
        for (Object str : help2.toArray()) {
            System.out.print(str);
        }
    }
}
