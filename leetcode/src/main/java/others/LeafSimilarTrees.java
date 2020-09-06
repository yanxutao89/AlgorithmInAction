package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.TreeNode;
import utils.TreeUtils;

/*Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



Note:

Both of the given trees will have between 1 and 100 nodes.*/
public class LeafSimilarTrees {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Leaf-Similar Trees.
	 * Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Leaf-Similar Trees.
	 */
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		getLeafValues(root1, list1);
		getLeafValues(root2, list2);

		if(list1.size() != list2.size()) {

			return false;
		}

		for(int i = 0; i < list1.size(); i++) {

			if(list1.get(i) != list2.get(i)) {

				return false;
			}
		}
		return true;
    }

	private void getLeafValues(TreeNode root, List<Integer> list) {

		if(root == null) {

			return;
		}

		if(root.left == null && root.right == null) {

			list.add(root.val);
		}

		getLeafValues(root.left, list);
		getLeafValues(root.right, list);
	}

	public static void main(String[] args) {

		String input1 = ",1,2,3";
		String input2 = ",2,2,3";

		System.out.println(new LeafSimilarTrees().leafSimilar(TreeUtils.stringToTreeNode(input1), TreeUtils.stringToTreeNode(input2)));
	}
}
