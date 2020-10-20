package trees;

import beans.TreeNode;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
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
 *
 *
 * Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * Output: 20
 * Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
 * Example 2:
 *
 *
 *
 * Input: root = [4,3,null,1,2]
 * Output: 2
 * Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
 * Example 3:
 *
 * Input: root = [-4,-2,-5]
 * Output: 0
 * Explanation: All values are negatives. Return an empty BST.
 * Example 4:
 *
 * Input: root = [2,1,3]
 * Output: 6
 * Example 5:
 *
 * Input: root = [5,4,8,3,null,6,3]
 * Output: 7
 *
 *
 * Constraints:
 *
 * The given binary tree will have between 1 and 40000 nodes.
 * Each node's value is between [-4 * 10^4 , 4 * 10^4].
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/10/13 21:19
 */
public class MaximumSumBSTInBinaryTree {

	/**
	 * Runtime: 6 ms, faster than 80.44% of Java online submissions for Maximum Sum BST in Binary Tree.
	 * Memory Usage: 52.2 MB, less than 5.04% of Java online submissions for Maximum Sum BST in Binary Tree.
	 */
	int max = 0;
	public int maxSumBST(TreeNode root) {
		helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return max;
	}

	public int[] helper(TreeNode root, int lb, int ub){

		if(null == root) {
			return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
		}
		int[] left = helper(root.left, Integer.MIN_VALUE, root.val);
		int[] right = helper(root.right, root.val, Integer.MAX_VALUE);
		if(null != left && null != right){
			max = Math.max(max, left[0] + right[0] + root.val);
		}else{
			return null;
		}

		int llb = Math.min(root.val, left[1]);
		int lub = Math.max(root.val, right[2]);
		if(llb <= lb || lub >= ub) {
			return null;
		}

		return new int[]{left[0] + right[0] + root.val, llb, lub};

	}

	public static void main(String[] args) {
		String input = "[4,3,null,1,2]";
		TreeNode root = TreeUtils.stringToTreeNode(input);
		System.out.println(new MaximumSumBSTInBinaryTree().maxSumBST(root));
	}
}
