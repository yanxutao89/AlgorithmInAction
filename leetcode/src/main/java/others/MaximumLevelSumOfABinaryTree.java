package others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import beans.TreeNode;
import utils.TreeUtils;

/*Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.*/
public class MaximumLevelSumOfABinaryTree {


	/*
	 * Runtime: 18 ms, faster than 10.76% of Java online submissions for Maximum Level Sum of a Binary Tree.
	 * Memory Usage: 42.5 MB, less than 100.00% of Java online submissions for Maximum Level Sum of a Binary Tree.
	 */
	public static int maxLevelSum(TreeNode root) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		recursive(root, map, 1);

		int max = Integer.MIN_VALUE;
		int level = 1;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if(entry.getValue() > max ) {

				max = entry.getValue();
				level = entry.getKey();
			}
		}

    	return level;
    }

	private static void recursive(TreeNode root, Map<Integer, Integer> map, int index) {

		if(root == null) {

			return;
		}

		map.put(index, map.get(index) == null ? root.val : map.get(index) + root.val);

		index++;
		recursive(root.left, map, index);
		recursive(root.right, map, index);

	}


	/*
	 * Runtime: 9 ms, faster than 84.32% of Java online submissions for Maximum Level Sum of a Binary Tree.
	 * Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Maximum Level Sum of a Binary Tree.
	 */
	public static int maxLevelSum2(TreeNode root) {

		int res = 1;
		int max = Integer.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;

		while(!queue.isEmpty()) {

			int size = queue.size();
			int current = 0;
			level++;

			for(int i = 0; i < size; i++) {

				TreeNode node = queue.poll();
				current += node.val;

				if(node.left != null) {

					queue.offer(node.left);
				}

				if(node.right != null) {

					queue.offer(node.right);
				}
			}

			if(current > max) {

				max = current;
				res = level;
			}

		}

		return res;
	}

    public static void main(String[] args) {

    	String input = "[1,7,0,7,-8,null,null]";

    	TreeNode root = TreeUtils.stringToTreeNode(input);

    	System.out.println(maxLevelSum2(root));
    }
}
