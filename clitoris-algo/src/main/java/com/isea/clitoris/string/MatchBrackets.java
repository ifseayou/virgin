package com.isea.clitoris.string;

import java.util.Stack;

/**
 * Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class MatchBrackets {
    public static void main(String[] args) {

        System.out.println(matchBrackets("{[()]}")); // true
        System.out.println(matchBrackets("][{")); // false
        System.out.println(matchBrackets("(]")); // false
    }

    public static boolean matchBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
            }
            if (bracket == '}' || bracket == ']' || bracket == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char topStack = stack.pop();
                if (bracket == ')' && topStack != '('){
                    return false;
                }
                if (bracket == ']' && topStack != '['){
                    return false;
                }
                if (bracket == '}' && topStack != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
