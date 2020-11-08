package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *
 * Note:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/8 17:59
 */
public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int maxLenA = -1;
        int maxLenB = -1;
        int maxLenC = -1;
        int currLen = 0;
        int a = 0;
        int b = 0;

        while (a < A.length && b < B.length) {
            if (A[a] == B[b]) {
                currLen++;
                a++;
                b++;
            } else {
                currLen = 0;
                a++;
            }
            maxLenA = Math.max(maxLenA, currLen);
        }

        currLen = 0;
        a = 0;
        b = 0;
        while (a < A.length && b < B.length) {
            if (A[a] == B[b]) {
                currLen++;
                a++;
                b++;
            } else {
                currLen = 0;
                b++;
            }
            maxLenB = Math.max(maxLenB, currLen);
        }

        currLen = 0;
        a = 0;
        b = 0;
        while (a < A.length && b < B.length) {
            if (A[a] == B[b]) {
                currLen++;
            } else {
                currLen = 0;
            }
            maxLenC = Math.max(maxLenC, currLen);
            a++;
            b++;
        }

        return Math.max(Math.max(maxLenA, maxLenB), maxLenC);

    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 1};
        int[] B = {1, 0, 0, 0, 0};
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(A, B));
    }
}
