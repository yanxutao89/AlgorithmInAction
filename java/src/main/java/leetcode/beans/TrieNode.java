package leetcode.beans;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TrieNode {

    private Object object;
    private boolean isWord;
    private Map<Object, TrieNode> children = new TreeMap<>();

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Map<Object, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Object, TrieNode> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrieNode trieNode = (TrieNode) o;
        return isWord == trieNode.isWord && Objects.equals(object, trieNode.object) && Objects.equals(children, trieNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, isWord, children);
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "object=" + object +
                ", isWord=" + isWord +
                ", children=" + children +
                '}';
    }

}
