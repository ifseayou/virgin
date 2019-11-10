package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/7
 * @time 21:04
 * @target: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * ！！！ 先把字符串逆序，.tneduts a ma I ,然后在对单词逆序  .student a ma I
 */
public class Num44 {
    public String ReverseSentence(String str) {
        StringBuilder help = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            help.append(str.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        String[] splits = help.toString().split(" ");
        for (int i = 0; i < splits.length; i++) {
            if (i == splits.length - 1) {
                res.append(reverseWord(splits[i]));
            } else {
                res.append(reverseWord(splits[i])).append(" ");
            }
        }
        return res.toString();
    }

    private String  reverseWord(String word) {
        int tmp = 0;
        

        return new String();
    }

    public static void main(String[] args) {
        String str = "i am a student.";
    }
}
