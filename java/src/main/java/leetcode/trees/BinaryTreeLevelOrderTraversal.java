package leetcode.trees;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/29 12:54
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Runtime: 1 ms, faster than 53.21% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 39.3 MB, less than 34.69% of Java online submissions for Binary Tree Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        String input = ",3,9,20,null,null,15,7,";
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(TreeUtils.stringToTreeNode(input)));
    }
}
