package trees;

import beans.TreeNode;
import utils.TreeUtils;

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

    public int minDepth(TreeNode root) {

        return 0;
    }

    public static void main(String[] args) {
        String input = ",3,9,20,null,null,15,7,";
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(TreeUtils.stringToTreeNode(input)));
    }
}
