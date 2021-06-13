package leetcode.arrays;

import leetcode.beans.TrieNode;
import leetcode.utils.TrieNodeUtils;

import java.util.*;

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


    public String longestWord(String[] words) {

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNodeUtils.insert(root, word);
        }

        TrieNode node = TrieNodeUtils.search(root, "woa");

        return node == null ? "" : node.getObject().toString();
    }

    /**
     * Runtime: 15 ms, faster than 49.79% of Java online submissions for Longest Word in Dictionary.
     * Memory Usage: 51.6 MB, less than 5.77% of Java online submissions for Longest Word in Dictionary.
     */
    int maxLen = 0;
    String longestWord = "";

    public String longestWord0(String[] words) {
        TrieNode0 root = buildTrie0(words);
        for (int i = 0; i < 26; ++i) {
            if (root.children[i] != null) {
                dfs(root.children[i], 1);
            }
        }
        return longestWord;
    }

    TrieNode0 buildTrie0(String[] words) {
        TrieNode0 root = new TrieNode0();

        for (String word : words) {
            TrieNode0 p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode0();
                }
                p = p.children[c - 'a'];
            }
            p.isWord = true;
            p.word = word;
        }

        return root;
    }

    void dfs(TrieNode0 root, int depth) {
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

    class TrieNode0 {
        TrieNode0[] children = new TrieNode0[26];
        boolean isWord;
        String word;
    }

    /**
     * Runtime: 34 ms, faster than 15.73% of Java online submissions for Longest Word in Dictionary.
     * Memory Usage: 45.4 MB, less than 13.93% of Java online submissions for Longest Word in Dictionary.
     * @param words
     * @return
     */
    public String longestWord2(String[] words) {
        Arrays.sort(words);
        String result = "";
        HashSet<String> builtWords = new HashSet();
        for (String w : words) {
            if (w.length() == 1 || builtWords.contains(w.substring(0, w.length() - 1))) {
                if (w.length() > result.length()) {
                    result = w;
                }
                builtWords.add(w);
            }
        }
        return result;
    }

    int maxLen3 = 0;
    String longestWord3 = "";

    /**
     * Runtime: 33 ms, faster than 17.57% of Java online submissions for Longest Word in Dictionary.
     * Memory Usage: 52.2 MB, less than 5.12% of Java online submissions for Longest Word in Dictionary.
     * @param words
     * @return
     */
    public String longestWord3(String[] words) {
        TrieNode3 root = buildTrie3(words);
        if (root.children != null) {
            for (Object key : root.children.keySet()) {
                dfs3(root.children.get(key), 1);
            }
        }
        return longestWord3;
    }

    TrieNode3 buildTrie3(String[] words) {
        TrieNode3 root = new TrieNode3();

        for (String word : words) {
            TrieNode3 p = root;
            for (char c : word.toCharArray()) {
                if (p.children.get(c) == null) {
                    p.children.put(c, new TrieNode3());
                }
                p = p.children.get(c);
            }
            p.isWord = true;
            p.word = word;
        }

        return root;
    }

    void dfs3(TrieNode3 root, int depth) {
        if (!root.isWord) {
            return;
        }

        if (depth > maxLen3) {
            maxLen3 = depth;
            longestWord3 = root.word;
        }

        if (root.children != null) {
            for (Object key : root.children.keySet()) {
                dfs3(root.children.get(key), depth + 1);
            }
        }
    }

    class TrieNode3 {
        Map<Object, TrieNode3> children = new TreeMap<>();
        boolean isWord;
        String word;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"w", "wo", "wor", "worl", "world"};
        System.out.println(new LongestWordInDictionary().longestWord(words));
        System.out.println(new LongestWordInDictionary().longestWord0(words));
        System.out.println(new LongestWordInDictionary().longestWord2(words));
        System.out.println(new LongestWordInDictionary().longestWord3(words));
    }

}
