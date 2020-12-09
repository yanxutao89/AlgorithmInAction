package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * Runtime: 2372 ms, faster than 5.03% of Java online submissions for Maximum Length of Repeated Subarray.
     * Memory Usage: 38.9 MB, less than 93.04% of Java online submissions for Maximum Length of Repeated Subarray.
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {

        int maxLen = 0;
        int lenA = A.length;
        int lenB = B.length;

        for (int i = 0; i < lenA && lenA - i > maxLen; ++i) {
            for (int j = 0; j < lenB && lenB - j > maxLen; ++j) {
                if (A[i] == B[j]) {
                    int a = i;
                    int b = j;
                    int currLen = 0;
                    while (a < lenA && b < lenB) {
                        if (A[a] == B[b]) {
                            a++;
                            b++;
                            currLen++;
                        } else {
                            if (lenA - a <= maxLen || lenB - b <= maxLen) {
                                break;
                            }
                            b++;
                            currLen = 0;
                        }
                        maxLen = Math.max(maxLen, currLen);
                    }
                }
            }
        }

        return maxLen;

    }

    /**
     * Runtime: 90 ms, faster than 18.74% of Java online submissions for Maximum Length of Repeated Subarray.
     * Memory Usage: 47.8 MB, less than 68.08% of Java online submissions for Maximum Length of Repeated Subarray.
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B) {
        int rows = A.length, cols = B.length;
        int[][] dp = new int[rows][cols];

        int max = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(i - 1 >= 0 && j - 1 >= 0 && A[i] == B[j] && A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if(A[i] == B[j]){
                    dp[i][j] = 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 1};
        int[] B = {1, 0, 0, 0, 0};
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(A, B));
    }
}
