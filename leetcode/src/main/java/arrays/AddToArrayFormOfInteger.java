package arrays;

import java.util.*;

/**
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 *
 *
 * Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 * Note：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/9/6 18:42
 */
public class AddToArrayFormOfInteger {

    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Add to Array-Form of Integer.
     * Memory Usage: 41.5 MB, less than 49.80% of Java online submissions for Add to Array-Form of Integer.
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        String num = String.valueOf(K);
        char[] chars = num.toCharArray();
        int over = 0;
        int i = A.length - 1;
        int j = chars.length - 1;
        while (i > -1 || j > -1) {
            int i1 = 0 > i ? 0 : A[i];
            int i2 = 0 > j ? 0 : (int) chars[j] - 48;
            int sum = i1 + i2 + over;
            over = 0;
            if (sum > 9) {
                over = sum / 10;
                sum = sum - over * 10;
            }
            list.addFirst(sum);
            --i;
            --j;
        }
        if (0 != over) {
            list.addFirst(over);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        int K = 1;
        System.out.println(new AddToArrayFormOfInteger().addToArrayForm(A, K));
    }
}
