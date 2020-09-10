package others;

import java.util.LinkedList;
import java.util.Queue;

import beans.TreeNode;
import utils.TreeUtils;

/*Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.*/
public class InsertIntoABinarySearchTree {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
	 * Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Insert into a Binary Search Tree.
	 */
	public static TreeNode insertIntoBST(TreeNode root, int val) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		return bfs(queue, val);
    }

	private static TreeNode bfs(Queue<TreeNode> queue, int val) {

		TreeNode root = queue.peek();
		while(!queue.isEmpty()) {

			int size = queue.size();
			for(int i = 0; i < size; i++) {

				TreeNode node = queue.remove();

				if(val < node.val) {

					if(node.left != null) {

						queue.add(node.left);
					} else {

						node.left = new TreeNode(val);

						return root;
					}

				}

				if(val > node.val) {

					if(node.right != null) {

						queue.add(node.right);
					} else {

						node.right = new TreeNode(val);

						return root;
					}
				}

			}
		}

		return null;
	}

    public static void main(String[] args) {

    	String input = ",4,2,7,1,3,";
    	int val = 5;

    	System.out.println(TreeUtils.treeNodeToString(insertIntoBST(TreeUtils.stringToTreeNode(input), val)));
    }
}
