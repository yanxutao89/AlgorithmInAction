package others;

import java.util.ArrayList;
import java.util.List;

import beans.TreeNode;
import utils.TreeUtils;

/*Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.



Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.*/
public class SumOfRootToLeafBinaryNumbers {

	/*
	 * Runtime: 2 ms, faster than 29.71% of Java online submissions for Sum of Root To Leaf Binary Numbers.
	 * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Sum of Root To Leaf Binary Numbers.
	 */
	public int sumRootToLeaf(TreeNode root) {

		int sum = 0;
		List<String> list = new ArrayList<String>();

		String str = "";
		recursive(root, list, str);

		for(String string : list) {

			sum += Integer.parseInt(string, 2);
		}

		return sum;
    }

	private void recursive(TreeNode root, List<String> list, String str) {

		if(root == null) {
			return ;
		}

		if(root.left == null && root.right == null) {

			str += root.val;
			list.add(str);
		}

		str += root.val;

		recursive(root.left, list, str);
		recursive(root.right, list, str);
	}

	public static void main(String[] args) {

		String input = ",1,0,1,0,1,0,1,";

		System.out.println(new SumOfRootToLeafBinaryNumbers().sumRootToLeaf(TreeUtils.stringToTreeNode(input)));
	}
}
