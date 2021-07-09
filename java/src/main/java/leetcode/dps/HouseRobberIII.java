package leetcode.dps;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.*;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * <p>
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
public class HouseRobberIII {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber III.
     * Memory Usage: 38.7 MB, less than 38.93% of Java online submissions for House Robber III.
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0], arr[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) {
            return arr;
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        arr[0] = root.val + left[1] + right[1];
        arr[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return arr;
    }

    @Deprecated
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(0, root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1, size, current;
        while (!queue.isEmpty()) {
            size = queue.size();
            current = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    current += Math.max((left == null ? 0 : left.val) + (right == null ? 0 : right.val), node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (index == 1 || index == 2) {
                dp.add(index, Math.max(current, dp.get(index - 1)));
            } else {
                dp.add(index, Math.max(current + dp.get(index - 3), dp.get(index - 1)));
            }
            ++index;
        }
        return dp.get(index - 1);
    }

    public static void main(String[] args) {
        String input = ",3,4,5,1,3,null,1,";
        System.out.println(new HouseRobberIII().rob(TreeUtils.stringToTreeNode(input)));
        System.out.println(new HouseRobberIII().rob2(TreeUtils.stringToTreeNode(input)));
    }
}
