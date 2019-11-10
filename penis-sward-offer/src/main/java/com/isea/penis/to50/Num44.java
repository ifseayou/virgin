package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/7
 * @time 21:04
 * @target: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * ！！！ 先把字符串逆序，.tneduts a ma I ,然后在对单词逆序  student. a ma I
 */
public class Num44 {
    public String ReverseSentence(String str) {
        // 先将一个字符整理逆序
        char[] reverseSentence = reverseWord(str.toCharArray(), 0, str.length() - 1);
        int left = 0;
        int length = reverseSentence.length;
        for (int i = 0; i < length; i++) {
            if (' ' == reverseSentence[i] ) {
                reverseWord(reverseSentence, left, i - 1);
                left = i + 1;
            }
            if (reverseSentence[i] == reverseSentence[length - 1]){
                reverseWord(reverseSentence,left,i);
            }
        }
        return new String(reverseSentence);
    }

    private char[] reverseWord(char[] chars, int left, int right) {
        char tmp = ' ';
        while (left < right) {
            tmp = chars[right];
            chars[right] = chars[left];
            chars[left] = tmp;
            left++;
            right--;
        }
        return chars;
    }

    public static void main(String[] args) {
        String str = "i am a student.";
        Num44 num44 = new Num44();
//        System.out.println(num44.reverseWord("doog".toCharArray()));
        System.out.println(num44.ReverseSentence(str));
        System.out.println("--" + num44.ReverseSentence(" ") + "---");
        System.out.println(num44.ReverseSentence("Wonderful"));
        System.out.println(num44.ReverseSentence("a b"));
        System.out.println(num44.ReverseSentence("my gad"));

    }
}
