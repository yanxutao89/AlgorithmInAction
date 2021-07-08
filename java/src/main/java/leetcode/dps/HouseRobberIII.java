package leetcode.dps;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.*;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {

        return 0;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        return depth;
    }

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> dp = new ArrayList<>();
        int index = 0, size, current;

        while (!queue.isEmpty()) {
            size = queue.size();
            current = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    current += node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (index == 0) {
                dp.add(index, current);
            }
            else if (index == 1) {
                dp.add(index, Math.max(current, dp.get(index - 1)));
            }
            else {
                dp.add(index, Math.max(current + dp.get(index - 2), dp.get(index - 1)));
            }
            ++index;
        }
        return dp.get(index - 1);
    }

    public static void main(String[] args) {
        String input = ",2,1,3,null,4,";
        System.out.println(new HouseRobberIII().rob(TreeUtils.stringToTreeNode(input)));
    }
}
