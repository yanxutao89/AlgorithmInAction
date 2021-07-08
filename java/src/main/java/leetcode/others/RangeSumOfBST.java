package leetcode.others;

import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;


public class RangeSumOfBST {

	/*
	 * Runtime: 7 ms, faster than 8.02% of Java online submissions for Range Sum of BST.
	 * Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Range Sum of BST.
	 */
	public static int rangeSumBST(TreeNode root, int L, int R) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		return bfs(queue, L, R);
    }

	private static int bfs(Queue<TreeNode> queue, int L, int R) {

		int sum = 0;
		while(!queue.isEmpty()) {

			int size = queue.size();

			for(int i = 0; i < size; i++) {

				TreeNode node = queue.remove();

				if(node != null) {

					if(node.val >= L && node.val <= R) {

						sum += node.val;
					}
				}

				if(node.left != null) {

					queue.add(node.left);
				}

				if(node.right != null) {

					queue.add(node.right);
				}
			}
		}

		return sum;
	}

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
	 * Memory Usage: 44.5 MB, less than 98.84% of Java online submissions for Range Sum of BST.
	 */
	public static int rangeSumBST2(TreeNode root, int L, int R) {

		if(root != null) {

			if(root.val < L) {

				return rangeSumBST(root.right, L, R);
			} else if(root.val > R) {

				return rangeSumBST(root.left, L, R);
			} else {

				return rangeSumBST(root.left, L, R) + root.val + rangeSumBST(root.right, L, R);
			}
		}

		return 0;
    }

    public static void main(String[] args) {

    	String input = "[10,5,15,3,7,13,18,1,null,6]";

    	TreeNode root = TreeUtils.stringToTreeNode(input);
    	int L = 6, R = 10;

    	System.out.println(rangeSumBST2(root, L, R));
    }
}
