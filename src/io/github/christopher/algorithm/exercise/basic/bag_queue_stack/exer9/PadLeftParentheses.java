package io.github.christopher.algorithm.exercise.basic.bag_queue_stack.exer9;

import edu.princeton.cs.algs4.Stack;

/**
 * 补齐左边遗漏的括号
 * @author Christopher.Wang 2017/2/18.
 */
public class PadLeftParentheses {
    public static String pad(String input) {
        String[] expressionElements = input.split(" ");
        String result = "";
        Stack<String> rightParentheses = new Stack<String>();
        for (int i = expressionElements.length - 1; i >= 0; i--) {
            String expressionElement = expressionElements[i];
            if (expressionElement.equals(")")) {
            } else if (expressionElement.indexOf("+-*/") > 0) {

            } else {

            }
        }
        return result;
    }
}
