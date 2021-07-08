package leetcode.others;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

/*Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.


Example 1:

Input: root = [1,2,3]
Output: [1,2,3]
Explanation:
The deepest leaves are the nodes with values 2 and 3.
The lowest common ancestor of these leaves is the node with value 1.
The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
Example 2:

Input: root = [1,2,3,4]
Output: [4]
Example 3:

Input: root = [1,2,3,4,5]
Output: [2,4,5]


Constraints:

The given tree will have between 1 and 1000 nodes.
Each node of the tree will have a distinct value between 1 and 1000.*/
public class LowestCommonAncestorOfDeepestLeaves {

	/*
	 * Runtime: 1 ms, faster than 82.47% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
	 * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
	 */
	 public TreeNode lcaDeepestLeaves(TreeNode root) {

		 if (root == null) {

			 return null;
		 }

		 int left = getMaxDepth(root.left);
	     int right = getMaxDepth(root.right);

	     return left == right ? root : (left < right ? lcaDeepestLeaves(root.right) : lcaDeepestLeaves(root.left));

	 }

    private int getMaxDepth(TreeNode node) {

    	if (node == null) {

        	return 0;
        }

    	return 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }

	public static void main(String[] args) {

		String input = ",1,2,3,";

		System.out.println(TreeUtils.treeNodeToString(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(TreeUtils.stringToTreeNode(input))));
	}
}
