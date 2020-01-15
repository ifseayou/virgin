package com.isea.glans.leetcode.easy;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/15 17:23
 * @target:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 *
 * 方法，水平扫描法
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length ; i ++){
            while(strs[i].indexOf(prefix) != 0){
                prefix  = prefix.substring(0,prefix.length() -1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
