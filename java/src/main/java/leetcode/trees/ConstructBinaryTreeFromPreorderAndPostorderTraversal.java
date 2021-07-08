package leetcode.trees;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

/**
 * Return any binary tree that matches the given preorder and postorder traversals.
 * Values in the traversals pre and post are distinct positive integers.
 *
 * Example 1:
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 * Note:
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

	/**
	 * Runtime: 1 ms, faster than 58.96% of Java online submissions for Construct Binary Tree from Preorder and Postorder Traversal.
	 * Memory Usage: 38.4 MB, less than 62.04% of Java online submissions for Construct Binary Tree from Preorder and Postorder Traversal.
	 * @param pre
	 * @param post
	 * @return
	 */
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return recursive(pre, post, 0, post.length - 1);
    }

	private TreeNode recursive(int[] pre, int[] post, int preLeft,  int preRight) {
		if(preLeft ==  preRight) {
			return new TreeNode(pre[preLeft]);
		}

		if(preLeft > preRight) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preLeft]);
		int rightIndex = getIndex(pre, post[getIndex(post, root.val) - 1 < 0 ? 0 : getIndex(post, root.val) - 1]);

		root.left = recursive(pre, post, preLeft + 1, rightIndex - 1);
		root.right = recursive(pre, post, rightIndex, preRight);

		return root;
	}

	private int getIndex(int[] arr, int val) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == val) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] post = {4,5,2,6,7,3,1};
		System.out.println(TreeUtils.treeNodeToString(new ConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(pre, post)));
	}
}
