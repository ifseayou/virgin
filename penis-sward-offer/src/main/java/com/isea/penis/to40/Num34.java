package com.isea.penis.to40;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author isea_you
 * @date 2019/11/5
 * @time 11:16
 * @target: 在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * !!! 这是一种很简单的解法，但是额外空间复杂度是O（N）
 */
public class Num34 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> charNums = new LinkedHashMap<>();
        HashMap<Character, Integer> charIndex = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!charNums.containsKey(c)) {
                charNums.put(c, 1);
                charIndex.put(c,i);
            } else {
                charNums.put(c, charNums.get(c) + 1);
            }
        }
        for (Character c : charNums.keySet()) {
            if (1 == charNums.get(c)){
                return charIndex.get(c);
            }
        }
        return -1;
    }
}
