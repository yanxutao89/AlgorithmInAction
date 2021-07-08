package leetcode.arrays;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {

    /**
     * Runtime: 12 ms, faster than 98.31% of Java online submissions for First Bad Version.
     * Memory Usage: 35.3 MB, less than 97.41% of Java online submissions for First Bad Version.
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int low = 0, mid, high = n - 1;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.println(new FirstBadVersion().firstBadVersion(n));
    }
}
