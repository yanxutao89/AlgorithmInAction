package arrays;

/**
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.
 * Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.
 *
 * Example 1:
 * Input: n = 3
 * Output: 2
 * Explanation: arr = [1, 3, 5]
 * First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
 * In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
 * Example 2:
 * Input: n = 6
 * Output: 9
 *
 * Constraints:
 * 1 <= n <= 10^4
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/10/11 17:03
 */
public class MinimumOperationsToMakeArrayEqual {

    /**
     * Runtime: 1 ms, faster than 77.11% of Java online submissions for Minimum Operations to Make Array Equal.
     * Memory Usage: 35.7 MB, less than 6.36% of Java online submissions for Minimum Operations to Make Array Equal.
     * @param n
     * @return
     */
    public int minOperations(int n) {

        int res = 0;
        if ((n & 1) == 1) {
            for (int i = 0; i < n >> 1; ++i) {
                res += (i + 1) * 2;
            }
        } else {
            for (int i = 0; i < n >> 1; ++i) {
                res += i * 2 + 1;
            }
        }

        return res;

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Operations to Make Array Equal.
     * Memory Usage: 35.8 MB, less than 6.36% of Java online submissions for Minimum Operations to Make Array Equal.
     * @param n
     * @return
     */
    public int minOperations2(int n) {

        if ((n & 1) == 1) {
            return  (2 + (n >> 1) * 2) * (n >> 1) >> 1;
        } else {
            return  (1 + (n >> 1) * 2 - 1) * (n >> 1) >> 1;
        }

    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new MinimumOperationsToMakeArrayEqual().minOperations(n));
        System.out.println(new MinimumOperationsToMakeArrayEqual().minOperations2(n));
    }
}
