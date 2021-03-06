package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
 * Example 4:
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 * Example 5:
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 * ​​​​​​​There are no other valid combinations.
 *
 * Constraints:
 * 2 <= k <= 9
 * 1 <= n <= 60
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/15 13:04
 */
public class CombinationSumIII {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
     * Memory Usage: 36.8 MB, less than 44.89% of Java online submissions for Combination Sum III.
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45 || k <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, k, n, 1, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int k, int n, int p, List<Integer> path) {
        if (n == 0 || k <= 0 || p >= 10) {
            if (n == 0 && k == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = p; i <= 9 && i <= n; ++i) {
            path.add(i);
            dfs(res, k - 1, n - i, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(new CombinationSumIII().combinationSum3(k, n));
    }
}
