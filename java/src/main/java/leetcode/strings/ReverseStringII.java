package leetcode.strings;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 */
public class ReverseStringII {

    /**
     * Runtime: 1 ms, faster than 70.89% of Java online submissions for Reverse String II.
     * Memory Usage: 39 MB, less than 60.92% of Java online submissions for Reverse String II.
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int num = (int) Math.ceil(chars.length / (2.0 * k));

        for (int i = 0; i < num; ++i) {
            int left = i * 2 * k;
            int right = chars.length - left < k ? chars.length - 1 : left + k - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                ++left;
                --right;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "abcabcab";
        int k = 3;
        System.out.println(new ReverseStringII().reverseStr(s, k));
    }

}
