package trees;

import beans.TreeNode;
import utils.TreeUtils;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/04 15:54
 */
public class DiameterOfBinaryTree {

	public int diameterOfBinaryTree(TreeNode root) {

		if (null == root) {
			return 0;
		}
		int ld = getDepth(root.left);
		int rd = getDepth(root.right);
		if (0 != ld && 0 != rd) {
			return 1 + ld + rd;
		} else {
			return ld + rd;
		}
	}

	private int getDepth(TreeNode node) {

		int depth = 0;
		if (null == node) {
			return depth;
		} else {
			depth++;
		}
		getDepth(node.left);
		getDepth(node.right);

		return depth;
	}

	public static void main(String[] args) {
		String input = ",1,2,3,4,5,null,null,";
		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(TreeUtils.stringToTreeNode(input)));
	}
}
