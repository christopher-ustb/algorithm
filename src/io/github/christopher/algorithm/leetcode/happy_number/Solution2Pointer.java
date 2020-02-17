package io.github.christopher.algorithm.leetcode.happy_number;

/**
 * @author wangchao003 20/2/17.
 */
public class Solution2Pointer {
    private int sumOfBitsSquare(int n) {
        int result = 0;
        while (n != 0) {
            int b = n % 10;
            result += b * b;
            n /= 10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumOfBitsSquare(slow);
            fast = sumOfBitsSquare(fast);
            fast = sumOfBitsSquare(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        Solution2Pointer solution2Pointer = new Solution2Pointer();
        System.out.println(solution2Pointer.isHappy(199));
    }
}
