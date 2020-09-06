package others;

import bean.TreeNode;
import utils.TreeUtils;

/*Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in its subtree.



Example 1:

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:



We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.


Note:

The number of nodes in the tree will be between 1 and 500.
The values of each node are unique.*/
public class SmallestSubtreeWithAllTheDeepestNodes {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
	 * Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
	 */
	TreeNode res = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        int depth = getDepth(root);
        int[] count = new int[1];
        getCount(root, count, depth, 1);
        dfs(root, count[0], depth, 1);
        return res;
    }

    private int dfs(TreeNode root, int count, int depth, int cur) {
        if (root == null) {
            return 0;
        }
        int sum = cur == depth ? 1 : 0;
        int left = dfs(root.left, count, depth, cur + 1);
        int right = dfs(root.right, count, depth, cur + 1);
        sum += left + right;
        if (sum == count && res == null) {
            res = root;
        }
        return sum;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int max = 1;
        max += Math.max(getDepth(node.left), getDepth(node.right));
        return max;
    }

    private void getCount(TreeNode node, int[] count, int depth, int cur) {
        if (node == null) {
            return;
        }
        if (depth == cur) {
            count[0]++;
        }
        getCount(node.left, count, depth, cur + 1);
        getCount(node.right, count, depth, cur + 1);
    }

	public static void main(String[] args) {

		String input = ",3,5,1,6,2,0,8,null,null,7,4,";

		System.out.println(TreeUtils.treeNodeToString(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(TreeUtils.stringToTreeNode(input))));
	}
}
