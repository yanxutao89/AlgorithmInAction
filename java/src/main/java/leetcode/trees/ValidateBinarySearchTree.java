package leetcode.trees;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/10/19 8:54
 */
public class ValidateBinarySearchTree {

	/**
	 * Runtime: 1 ms, faster than 37.69% of Java online submissions for Validate Binary Search Tree.
	 * Memory Usage: 39.1 MB, less than 8.71% of Java online submissions for Validate Binary Search Tree.
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList();
		isValidBSTByList(root, list);
		for (int i = 0; i < list.size() - 1; ++i) {
			if (list.get(i) >= list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	private void isValidBSTByList(TreeNode root, List<Integer> list) {

		if (null == root) {
			return ;
		}

		isValidBSTByList(root.left, list);
		list.add(root.val);
		isValidBSTByList(root.right, list);

	}

	public boolean isValidBST2(TreeNode root) {

		if (null == root) {
			return false;
		}



		return true;
	}

	public static void main(String[] args) {

		String input = ",2,1,3,";
		System.out.println(new ValidateBinarySearchTree().isValidBST(TreeUtils.stringToTreeNode(input)));
		System.out.println(new ValidateBinarySearchTree().isValidBST2(TreeUtils.stringToTreeNode(input)));
	}
}
