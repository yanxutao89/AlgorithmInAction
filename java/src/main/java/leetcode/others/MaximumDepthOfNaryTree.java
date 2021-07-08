package leetcode.others;

import leetcode.beans.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:






We should return its max depth, which is 3.



Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.*/
public class MaximumDepthOfNaryTree {

	/*
	 * Runtime: 2 ms, faster than 26.67% of Java online submissions for Maximum Depth of N-ary Tree.
	 * Memory Usage: 46.4 MB, less than 52.38% of Java online submissions for Maximum Depth of N-ary Tree.
	 */
	public int maxDepth(Node root) {

		int depth = 0;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()) {

			int size = queue.size();
			for(int i = 0; i < size; i++) {

				Node node = queue.remove();

				if(node != null) {

					queue.addAll(node.children);
				}
			}

			depth++;
		}

		return depth;

    }

	private int recursive(List<Node> list, int depth) {

		if(list.size() == 0) {

			return depth;
		}

		for(Node node : list) {

			if(node != null) {

				return recursive(node.children, depth + 1);
			}
		}

		return -1;
	}

	/*
	 * Runtime: 1 ms, faster than 97.74% of Java online submissions for Maximum Depth of N-ary Tree.
	 * Memory Usage: 46.4 MB, less than 52.38% of Java online submissions for Maximum Depth of N-ary Tree.
	 */
	public int maxDepth2(Node root) {

		if (root == null) {
			return 0;
        }
        if (root.children.size() == 0) {
        	return 1;
        }

        int maxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int depth = maxDepth(root.children.get(i));
            if (depth > maxDepth) {

            	maxDepth = depth;
            }
        }
        return maxDepth + 1;
    }

	public static void main(String[] args) {


	}
}
