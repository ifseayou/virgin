package com.isea.penis.to10;

import java.util.Stack;

/**
 * @author isea_you
 * @date 2019/10/23
 * @time 16:13
 * @target: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Num5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        dump();
        return stack2.pop();
    }

    private void dump() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
}
