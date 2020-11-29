package trees;

import java.util.LinkedList;
import java.util.Queue;

import beans.TreeNode;
import utils.TreeUtils;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 * Constraints:
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * The values of preorder are distinct.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    /**
     * Runtime: 1 ms, faster than 23.90% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
     * Memory Usage: 37.4 MB, less than 11.16% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
     * @param preorder
     * @return
     */
	public static TreeNode bstFromPreorder(int[] preorder) {

		if (preorder == null || preorder.length == 0) {
            return null;
        }

		Queue<Integer> queue = new LinkedList<>();

		for (int num : preorder) {
            queue.offer(num);
        }

        return lowerUpperBound(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode lowerUpperBound(Queue<Integer> q, int lower, int upper) {

    	if (q.isEmpty()) {
    		return null;
        }

        int val = q.peek();
        if (val < lower || val > upper) {
        	return null;
        }

        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = lowerUpperBound(q, lower, val);
        root.right = lowerUpperBound(q, val, upper);

        return root;
    }

    public static void main(String[] args) {
    	int[] preorder = {8,5,1,7,10,12};
    	System.out.println(TreeUtils.treeNodeToString(bstFromPreorder(preorder)));
    }
}
