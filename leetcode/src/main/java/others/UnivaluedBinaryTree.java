package others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import beans.TreeNode;
import utils.TreeUtils;

/*A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.



Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false


Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
*/
public class UnivaluedBinaryTree {


	/*
	 * Runtime: 1 ms, faster than 15.77% of Java online submissions for Univalued Binary Tree.
	 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Univalued Binary Tree.
	 */
	public boolean isUnivalTree(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		Set<Integer> set = new HashSet<Integer>();
		while(!queue.isEmpty()) {

			int size = queue.size();

			for(int i = 0; i < size; i++) {

				TreeNode node = queue.remove();
				set.add(node.val);

				if(node.left != null) {

					queue.add(node.left);
				}

				if(node.right != null) {

					queue.add(node.right);
				}
			}

		}

		return set.size() == 1;
    }

	/*
	 * Runtime: 1 ms, faster than 15.77% of Java online submissions for Univalued Binary Tree.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Univalued Binary Tree.
	 */
	public boolean isUnivalTree2(TreeNode root) {

		Set<Integer> set = new HashSet<Integer>();

		recursive(set, root);

		return set.size() == 1;
    }

	private void recursive(Set<Integer> set, TreeNode root) {

		if(root == null) {

			return;
		}

		set.add(root.val);

		recursive(set, root.left);
		recursive(set, root.right);
	}

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
	 * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Univalued Binary Tree.
	 */
	public boolean isUnivalTree3(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		return bfs(queue, root.val);
    }

	private boolean bfs(Queue<TreeNode> queue, int val) {

		while(!queue.isEmpty()) {

			int size = queue.size();

			for(int i = 0; i < size; i++) {

				TreeNode node = queue.remove();

				if(node.val != val) {

					return false;
				}

				if(node.left != null) {

					queue.add(node.left);
				}

				if(node.right != null) {

					queue.add(node.right);
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {

		String input = ",1,1,1,1,1,null,2,";

		System.out.println(new UnivaluedBinaryTree().isUnivalTree3(TreeUtils.stringToTreeNode(input)));
	}
}
