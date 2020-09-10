package others;

import beans.TreeNode;
import utils.TreeUtils;

/**
 * Given the root of a binary search tree with distinct values, modify it so that
 * every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * Note:
 * The number of nodes in the tree is between 1 and 100.
 * Each node will have value between 0 and 100.
 * The given tree is a binary search tree.
 *
 * @author Dell
 *
 */

public class BinarySearchTree2GreaterSumTree {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
	 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Binary Search Tree to Greater Sum
	 */
	static int val = 0;

    public static TreeNode bstToGst(TreeNode root) {

    	if (val != 0) {
    		val = 0;
    	}
        recursive(root);

        return root;
    }

    public static void recursive(TreeNode root) {

    	if(root != null) {
    		recursive(root.right);
    		root.val += val;
    		val = root.val;
    		recursive(root.left);
    	}
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
     * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
     *
     */
    public static TreeNode bstToGst2(TreeNode root) {

        recursive2(root, 0);

        return root;
    }

    private static int recursive2(TreeNode root, Integer val) {

    	if (root == null) {

    		return val;
    	}

    	root.val = root.val + recursive2(root.right, val);

    	return recursive2(root.left, root.val);
    }

    public static void main(String[] args) {

    	String input = "[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]";

    	TreeNode root = TreeUtils.stringToTreeNode(input);

    	System.out.println(TreeUtils.treeNodeToString(bstToGst2(root)));
    }
}
