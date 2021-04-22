package leetcode.arrays;

/**
 * Given two strings s and t, check if s is a subsequence of t.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Subsequence.
     * Memory Usage: 36.9 MB, less than 63.85% of Java online submissions for Is Subsequence.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        int count = 0;
        int start = 0;
        for (int i = 0; i < chars.length; ++i) {
            for (int j = start; j < chars1.length; ++j) {
                ++start;
                if (chars[i] == chars1[j]) {
                    ++count;
                    break;
                }
            }
        }

        return count == chars.length;
    }

    public static void main(String[] args) {
        String s = "abd";
        String t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }

}
