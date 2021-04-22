package trees;

import beans.TreeNode;
import utils.TreeUtils;

/**
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 *
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 *
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 *
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 * Note:
 *
 * 	The binary tree will have at most 100 nodes.
 * 	The value of each node will only be 0 or 1.
 */
public class BinaryTreePruning {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Pruning.
	 * Memory Usage: 36.6 MB, less than 8.85% of Java online submissions for Binary Tree Pruning.
	 * @param root
	 * @return
	 */
	public TreeNode pruneTree(TreeNode root) {

		if(root == null) {
			return null;
		}

		if(!containsOne(root.left)) {
			root.left = null;
		}

		if(!containsOne(root.right)) {
			root.right = null;
		}

		pruneTree(root.left);
		pruneTree(root.right);

		return containsOne(root) ? root : null;

    }

	public static boolean containsOne(TreeNode root) {

		if(root == null) {
			return false;
		}

		if(root.val == 1) {
			return true;
		}

		boolean b1 = containsOne(root.left);
		boolean b2 = containsOne(root.right);

		return b1 || b2;
	}

	public static void main(String[] args) {

		String input = ",0,null,0,0,0,";
		TreeNode root = TreeUtils.stringToTreeNode(input);
		System.out.println(TreeUtils.treeNodeToString(new BinaryTreePruning().pruneTree(root)));
	}
}
