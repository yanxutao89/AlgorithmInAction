package leetcode.arrays;

import java.util.Arrays;

/**
 * Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
 * <p>
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["w","wo","wor","worl","world"]
 * Output: "world"
 * Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * <p>
 * Input: words = ["a","banana","app","appl","ap","apply","apple"]
 * Output: "apple"
 * Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * words[i] consists of lowercase English letters.
 *
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/4/28 9:20
 */
public class LongestWordInDictionary {

    int maxLen = 0;
    String longestWord;

    public String longestWord(String[] words) {
        TrieNode root = buildTrie(words);
        for (int i = 0; i < 26; ++i) {
            if (root.children[i] != null) {
                dfs(root.children[i], 1);
            }
        }
        return longestWord;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.isWord = true;
            p.word = word;
        }

        return root;
    }

    void dfs(TrieNode root, int depth) {
        if (!root.isWord) {
            return;
        }

        if (depth > maxLen) {
            maxLen = depth;
            longestWord = root.word;
        }

        for (int i = 0; i < 26; ++i) {
            if (root.children[i] != null) {
                dfs(root.children[i], depth + 1);
            }
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        String word;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + Arrays.toString(children) +
                    ", isWord=" + isWord +
                    ", word='" + word + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"w", "wo", "wor", "worl", "world"};
        System.out.println(new LongestWordInDictionary().longestWord(words));
    }

}
