package leetcode.arrays;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Example 3:
 * <p>
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * Example 4:
 * <p>
 * Input: dividend = 1, divisor = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */

public class DivideTwoIntegers {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.
     * Memory Usage: 36.1 MB, less than 66.24% of Java online submissions for Divide Two Integers.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                ++count;
            }
            quotient += 1 << count;
            dividend -= divisor << count;
        }
        return sign ? quotient : -quotient;
    }

    public static void main(String[] args) {
        int dividend = 100, divisor = 3;
        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }
}
