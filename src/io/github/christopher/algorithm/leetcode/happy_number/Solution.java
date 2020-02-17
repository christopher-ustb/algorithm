package io.github.christopher.algorithm.leetcode.happy_number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangchao003 20/2/17.
 */
public class Solution {
    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (set.contains(n)) {
            return false;
        } else {
            set.add(n);
        }
        List<Integer> bits10 = new ArrayList<>();
        while (n != 0) {
            bits10.add(n % 10);
            n /= 10;
        }
        int sumOfBitsSquare = 0;
        for (Integer b : bits10) {
            sumOfBitsSquare += b * b;
        }
        if (sumOfBitsSquare == 1) {
            return true;
        } else {
            return isHappy(sumOfBitsSquare);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(18));
    }
}
