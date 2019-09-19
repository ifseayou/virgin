package com.isea.clitoris.string;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 表达式计算，这里面只是涉及到“+，-，*，/”，分子为0的情况不考虑
 * 比如：3 + 5 * 8 - 6
 */
public class CalculateExpression {

    public static double calaculateExpression(String target){
        Stack<Character> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if(Pattern.matches("\\d",String.valueOf(c))){
                numStack.push(c);
            }
            
            if (Pattern.matches("\\+|-|\\*|/",String.valueOf(c))){

            }
        }

        return  0;

    }
}
