package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/12
 * @time 7:53
 * @target: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入一个字符串,包括数字字母符号,可以为空；如果是合法的数值表达则返回该数字，否则返回0
 * +123 return 0 ，不符合书写  习惯！
 * 012  return 0
 * 123 return 123
 * 0 return 0
 * -123 return -123
 * a12 return 0
 * 012 return 0
 * -0 return 0
 * 3222323232323  return 0 // 因为溢出了
 */
public class Num49 {
    public int StrToInt(String str) {
        // 如果字符串是null 或者是 ""
        if (str == null || "".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        if (!isValid(chars)){
            return 0;
        }

        boolean posi = chars[0] == '-' ? false : true;
        int minQuotient = Integer.MIN_VALUE / 10; // quotient
        int minRemainder = Integer.MIN_VALUE % 10; // remainder
        int res = 0;
        int cur = 0;
        for (int i = (posi == false || chars[0] == '+') ? 1 : 0 ; i < chars.length ; i ++){
            cur = '0' - chars[i];
            if (res < minQuotient || (res == minQuotient && cur < minRemainder)){
                return  0;
            }
            res = res  * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE){
            return 0;
        }
        return posi ? -res : res;
    }

    // 判断一个字符串是否是合法的数字类型的字符串
    public boolean isValid(char[] chars){
        // 不以"-"开头，也不以数字开头，如a12
/*
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')){ // 不允许 +123 的情况
            return false;
        }
*/

        if (chars[0] != '-' && chars[0] != '+' && (chars[0] < '0' || chars[0] > '9')){ // 允许+123的情况
            return false;
        }
        // 以-开头，但是长度为1，或者是-0
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')){
            return false;
        }
        // 以0开头，但是长度大于1
        if (chars[0] == '0' && chars.length > 1){
            return false;
        }
        // 经历过1,2,3之后，检验后面的字符是否都是字符串
        for (int i = 1 ; i < chars.length ; i ++){
            if (chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Num49 num49 = new Num49();
        System.out.println(num49.StrToInt("1+2"));
        System.out.println(num49.StrToInt("124"));
        System.out.println(num49.StrToInt("-124"));
        System.out.println(num49.StrToInt("+124"));
        System.out.println(num49.StrToInt(""));
        System.out.println(num49.StrToInt("-2147483649"));
        System.out.println(num49.StrToInt("-2147483648"));
        System.out.println(num49.StrToInt("2147483648"));
    }
}
