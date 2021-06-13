package leetcode.utils;

import leetcode.beans.TrieNode;

import java.util.Map;

public class TrieNodeUtils {

    public static void insert(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            Map<Object, TrieNode> children = node.getChildren();
            if (children.get(c) == null) {
                children.put(c, new TrieNode());
            }
            node = children.get(c);
        }
        node.setObject(word);
        node.setWord(true);
    }

    public static TrieNode search(TrieNode root, String word) {
        Object[] objects = new Object[word.length()];
        char[] chars = word.toCharArray();
        for (int i = 0; i < objects.length; ++i) {
            objects[i] = chars[i];
        }
        return dfs(root, objects, 0);
    }

    private static TrieNode dfs(TrieNode root, Object[] objects, int index) {
        if (root == null || index > objects.length - 1) {
            return null;
        }
        Map<Object, TrieNode> children = root.getChildren();
        if (children != null) {
            TrieNode node = children.get(objects[index]);
            if (node != null) {
                if (index == objects.length - 1 && node.isWord()) {
                    return node;
                }
            }
        }
        return dfs(children.get(objects[index]), objects, index + 1);
    }

}
