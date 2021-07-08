package leetcode.trees;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/29 17:59
 */
public class MinimumDepthOfBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 59.1 MB, less than 64.92% of Java online submissions for Minimum Depth of Binary Tree.
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        String input = ",3,9,20,null,null,15,7,";
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(TreeUtils.stringToTreeNode(input)));
    }
}
