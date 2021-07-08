package leetcode.trees;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

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

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
	 * Memory Usage: 39.5 MB, less than 8.77% of Java online submissions for Diameter of Binary Tree.
	 */
	int ans = 1;
	public int diameterOfBinaryTree(TreeNode root) {
		dfs(root);
		return ans - 1;
	}

	public int dfs(TreeNode root){
		if(null == root) {
			return 0;
		}
		int ld = dfs(root.left);
		int rd = dfs(root.right);
		ans = Math.max(ans, 1 + ld + rd);
		return 1 + Math.max(ld, rd);
	}

	public static void main(String[] args) {
		String input = ",2,3,null,1,";
		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(TreeUtils.stringToTreeNode(input)));
	}
}
