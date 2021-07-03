package leetcode.trees;

import beans.TreeNode;
import utils.TreeUtils;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * <p>
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class LowestCommonAncestorOfABinaryTree {

    private TreeNode node;

    /**
     *
     * Runtime: 2126 ms, faster than 5.03% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 40.9 MB, less than 70.59% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (has(root, p.val) && has(root, q.val)) {
            node = root;
        }

        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);

        return node;
    }

    private boolean has(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        return has(root.left, val) || has(root.right, val);
    }

    /**
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 41.2 MB, less than 51.26% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    /**
     * Runtime: 10 ms, faster than 19.19% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 39.6 MB, less than 98.41% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            if (parentMap.containsKey(p) && parentMap.containsKey(q)) {
                break;
            }

            TreeNode curr = stack.pop();
            if (curr == null) {
                continue;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                stack.push(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                stack.push(curr.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public static void main(String[] args) {
        String input = ",3,5,1,6,2,0,8,null,null,7,4,";
        String p = ",5,";
        String q = ",4,";
        System.out.println(TreeUtils.treeNodeToString(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(
                TreeUtils.stringToTreeNode(input),
                TreeUtils.stringToTreeNode(p),
                TreeUtils.stringToTreeNode(q))));
        System.out.println(TreeUtils.treeNodeToString(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor2(
                TreeUtils.stringToTreeNode(input),
                TreeUtils.stringToTreeNode(p),
                TreeUtils.stringToTreeNode(q))));
        System.out.println(TreeUtils.treeNodeToString(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor3(
                TreeUtils.stringToTreeNode(input),
                TreeUtils.stringToTreeNode(p),
                TreeUtils.stringToTreeNode(q))));
    }
}
