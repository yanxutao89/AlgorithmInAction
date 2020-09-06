package others;

import java.util.LinkedList;
import java.util.Queue;

import bean.TreeNode;
import utils.TreeUtils;

/*Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node,
any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)*/
public class ConstructBinarySearchTreeFromPreorderTraversa {


	/*
	 * Runtime: 1 ms, faster than 41.03% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
	 * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
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

    // using UPPER and LOWER bound to recover the tree from pre-order queue
    public static TreeNode lowerUpperBound(Queue<Integer> q, int lower, int upper) {

    	if (q.isEmpty()) {
    		return null;
        }

        int val = q.peek();
        if (val < lower || val > upper) {
        	return null;
        }

        q.poll();

        TreeNode root = new TreeNode(val);

        // left subtree has upper bound val, while right subtree has lower bound val
        root.left = lowerUpperBound(q, lower, val);
        root.right = lowerUpperBound(q, val, upper);

        return root;
    }

    public static void main(String[] args) {

    	int[] preorder = {8,5,1,7,10,12};

    	System.out.println(TreeUtils.treeNodeToString(bstFromPreorder(preorder)));
    }
}
