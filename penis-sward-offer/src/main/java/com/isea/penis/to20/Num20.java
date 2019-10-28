package com.isea.penis.to20;

import java.util.Stack;

/**
 * @author isea_you
 * @date 2019/10/28
 * @time 10:42
 * @target: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Num20 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty() || node < stack2.peek()){ // empty || node < min;
            stack2.push(node);
        }else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()){
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        if (stack1.isEmpty()){
            throw new IllegalArgumentException("stack empty...");
        }
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()){
            throw new IllegalArgumentException("stack empty...");
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        Num20 num20 = new Num20();
        num20.push(3);
        num20.push(2);
        num20.push(3);
        num20.push(1);
        System.out.println(num20.min());
        num20.pop();
        System.out.println(num20.min());
    }
}
