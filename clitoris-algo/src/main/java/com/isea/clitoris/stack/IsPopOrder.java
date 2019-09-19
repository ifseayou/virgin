package com.isea.clitoris.stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 按照入栈的顺序压栈，判断栈顶的元素和出栈的元素是否相等，如果相等，出栈。
 *
 */
public class IsPopOrder {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> help = new Stack();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            help.push(pushA[i]);
            while(!help.isEmpty() && help.peek() == popA[popIndex]){
                help.pop();
                popIndex ++;
            }
        }
        return help.isEmpty();
    }
}
