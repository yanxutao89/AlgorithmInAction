package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bean.TreeNode;
import utils.TreeUtils;

/*Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.



Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.*/
public class DeleteNodesAndReturnForest {


	/*
	 * Runtime: 4 ms, faster than 27.95% of Java online submissions for Delete Nodes And Return Forest.
	 * Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Delete Nodes And Return Forest.
	 */
private Set<Integer> set = new HashSet<>();

    private List<TreeNode> recursion(TreeNode root) {

        if (null == root) {
        }

        List<TreeNode> left = new ArrayList<TreeNode>();
        List<TreeNode> right = new ArrayList<TreeNode>();
        if(root.left != null) {

            left = recursion(root.left);
        }

        if(root.right != null) {

            right = recursion(root.right);
        }

        if (set.contains(root.val)) {
            left.addAll(right);
            return left;
        }

        boolean breakLeft = true, breakRight = true;

        List<TreeNode> result = new ArrayList<>();

        for (TreeNode node : left) {
            if (node.val == root.left.val) {
                breakLeft = false;
            } else {
                result.add(node);
            }
        }

        if (breakLeft) {
            root.left = null;
        }

        for (TreeNode node : right) {
            if (node.val == root.right.val) {
                breakRight = false;
            } else {
                result.add(node);
            }
        }

        if (breakRight) {
            root.right = null;
        }

        result.add(root);
        return result;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for (int i = 0; i < to_delete.length; ++i) {
            set.add(to_delete[i]);
        }

        return recursion(root);
    }

	public static void main(String[] args) {

		String input = ",1,2,3,4,5,6,7,";
		int[] to_delete = {3,5};

		System.out.println(new DeleteNodesAndReturnForest().delNodes(TreeUtils.stringToTreeNode(input), to_delete));

	}

}
