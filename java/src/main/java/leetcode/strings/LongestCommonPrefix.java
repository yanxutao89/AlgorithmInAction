package leetcode.strings;

import leetcode.beans.TrieNode;
import leetcode.utils.TrieNodeUtils;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {

    /**
     * Runtime: 1 ms, faster than 61.79% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.3 MB, less than 41.98% of Java online submissions for Longest Common Prefix.
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        outer:
        while (index < minLen) {
            int count = -1;
            int i = 0;
            for (; i < len - 1; ++i) {
                if (strs[i].charAt(index) == strs[i + 1].charAt(index)) {
                    count = count == -1 ? 1 : ++count;
                } else {
                    break outer;
                }
            }
            if (count == len - 1) {
                sb.append(strs[i].charAt(index));
            }
            ++index;
        }

        return sb.toString();
    }

    /**
     * Runtime: 4 ms, faster than 23.82% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 38.4 MB, less than 35.19% of Java online submissions for Longest Common Prefix.
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        TrieNode root = new TrieNode();
        for (String s : strs) {
            TrieNodeUtils.insert(root, s);
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TrieNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(null == root.getObject() ? "" : root.getObject());
        if (root.isWord()) {
            return;
        }
        if (root.getChildren().size() > 1) {
            return;
        }
        else {
            for (TrieNode node : root.getChildren().values()) {
                dfs(node, sb);
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix2(strs));
    }
}
