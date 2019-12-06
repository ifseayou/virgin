package com.isea.penis.to30;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author isea_you
 * @date 2019/10/31
 * @time 9:30
 * @target: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * !!!
 * 1，把整个字符串看成是第一个字符串和后来的字符串的组合
 * 2，每次确定一个元素，和后面的元素依次兑换
 * 3，不懂，使用abc对着代码，人肉编译下
 */
public class Num27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] cs, int i, ArrayList<String> res) {
        // 递归终止条件
        if (i == cs.length - 1){
            String val = String.valueOf(cs);
            if (!res.contains(val)){
                res.add(val);
            }
        }else {
            for (int j = i; j < cs.length ; j++){
                swap(cs,i,j);
                PermutationHelper(cs,i+ 1,res);
                swap(cs,i,j);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
