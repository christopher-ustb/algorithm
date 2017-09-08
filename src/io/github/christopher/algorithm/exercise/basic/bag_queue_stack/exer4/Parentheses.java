package io.github.christopher.algorithm.exercise.basic.bag_queue_stack.exer4;

import edu.princeton.cs.algs4.Stack;

public class Parentheses {
//    public static final Character[] LEFT_PARENTHESES = new Character[]{
//            '(', '[', '{', '<'
//    };

//    public static final Character[] RIGHT_PARENTHESES = new Character[]{
//            ')', ']', '}', '>'
//    };

    public static final String LEFT_PARENTHESES = "([{<";
    public static final String RIGHT_PARENTHESES = ")]}>";

    public boolean isMatch(String parentheses) {
        Stack<Character> leftParentheses = new Stack<Character>();
        for (int i = 0; i < parentheses.length(); i++) {
            Character character = parentheses.charAt(i);
            if (LEFT_PARENTHESES.indexOf(character) >= 0) {
                leftParentheses.push(character);
            } else if (RIGHT_PARENTHESES.indexOf(character) >= 0) {
                char lastLeftParentheses = leftParentheses.pop();
                if (!isCouple(lastLeftParentheses, character)) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("不识别的括号字符");
            }
        }
        return leftParentheses.isEmpty();
    }

    private boolean isCouple(char l, char r) {
        int leftIndex = LEFT_PARENTHESES.indexOf(l);
        int rightIndex = RIGHT_PARENTHESES.indexOf(r);
        return leftIndex == rightIndex;
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        System.out.println(parentheses.isMatch("{([]){<[]>}()()}"));
        System.out.println(parentheses.isMatch("{{}"));
    }
}
