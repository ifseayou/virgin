package com.isea.penis.to60;

/**
 * @author isea_you
 * @date 2019/11/26
 * @time 15:23
 * @target: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Num55 {

    int count[] = new int[256];
    int index = 1;

    public void Insert(char ch) {
        if (count[ch] == 0) { // 该字符之前没有出现过
            count[ch] = index++;
        } else { // 该字符之前出现过，记录为-1，表示该字符之前出现过
            count[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
                temp = count[i];
                ch = (char) i;
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        Num55 num55 = new Num55();
        num55.FirstAppearingOnce();
        System.out.println();

        System.out.println((int)'g');
        System.out.println((int)'o');
        System.out.println((int)'l');
        System.out.println((int)'e');
    }
}
