package com.isea.penis.to10;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 11:39
 * @target: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Num2 {

    public String replaceSpace(StringBuffer str) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)){
                res.append("%20");
            }else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String target = "We Are Happy";
        StringBuffer sb = new StringBuffer(target);
        Num2 num2 = new Num2();
        System.out.println(num2.replaceSpace(sb));
    }
}
