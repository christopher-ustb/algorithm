package io.github.christopher.algorithm.leetcode.reverse_bits;

/**
 * @author wangchao003 20/2/17.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 0000001000000000
            int bitConjunction = 1 << (31 - i);
            int singleBitAndResult = bitConjunction & n;
            // i-th bit==1?
            if (singleBitAndResult != 0) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(-3));
    }
}
