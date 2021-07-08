package leetcode.others;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;


/*Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)



Example 1:



Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation:
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.


Note:

The number of nodes in the tree is between 2 and 5000.
Each node will have value between 0 and 100000.*/
public class MaximumDifferenceBetweenNodeAndAncestor {

	/*
	 * Runtime: 217 ms, faster than 5.15% of Java online submissions for Maximum Difference Between Node and Ancestor.
	 * Memory Usage: 37.5 MB, less than 22.22% of Java online submissions for Maximum Difference Between Node and Ancestor.
	 */
	public int maxAncestorDiff(TreeNode root) {

		int dif = Integer.MIN_VALUE;
		if(root == null || root.left == null && root.right == null) {

			return dif;
		}

		dif = Math.max(dif, getDif(root));

		return Math.max(dif, Math.max(maxAncestorDiff(root.left), maxAncestorDiff(root.right)));

    }

	private int getDif(TreeNode node) {

		int dif = Integer.MIN_VALUE;

		List<Integer> list = new ArrayList<Integer>();
		getChildValues(node, list);

		for(Integer integer : list) {

			dif = Math.max(dif, Math.abs(node.val - integer));
		}

		return dif;
	}

	private void getChildValues(TreeNode root, List<Integer> list) {

		if(root == null) {

			return ;
		}

		list.add(root.val);

		getChildValues(root.left, list);
		getChildValues(root.right, list);

	}

	public int maxAncestorDiff2(TreeNode root) {

		int dif = Integer.MIN_VALUE;
		if(root == null || root.left == null && root.right == null) {

			return dif;
		}

		dif = Math.max(dif, getMaxDif(root, root.val));

		if(root.left != null) {

			dif = Math.max(dif, maxAncestorDiff2(root.left));
		}

		if(root.right != null) {

			dif = Math.max(dif, maxAncestorDiff2(root.right));
		}

		return dif;
    }

	private int getMaxDif(TreeNode root, int val) {

		int dif = Integer.MIN_VALUE;
		if(root == null) {

			return dif;
		}

		dif = Math.max(dif, getDif2(root, root.val));

		if(root.left !=null && root.right == null) {

			return Math.max(dif, getMaxDif(root.left, root.left.val));
		}

		if(root.left == null && root.right != null) {

			return Math.max(dif, getMaxDif(root.right, root.right.val));
		}

		if(root.left != null && root.right != null) {

			return Math.max(dif, Math.max(getMaxDif(root.left, root.left.val), getMaxDif(root.right, root.right.val)));
		}

		return dif;
	}

	private int getDif2(TreeNode root, int val) {

		int dif = Integer.MIN_VALUE;

		if(root == null) {

			return -1;
		}

		dif = Math.max(dif, Math.abs(val - root.val));

		return Math.max(dif, Math.max(getDif2(root.left, val), getDif2(root.right, val)));
	}


	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
	 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
	 */
    private int out;

    public int maxAncestorDiff3(TreeNode root) {

    	if (root == null) {
    		return 0;
    	}

    	helper(root, root.val, root.val);

    	return this.out;
    }

	private void helper(TreeNode root, int ma, int mi) {

		if (root == null) {
	    	return;
	    }

	    out = Math.max(out, Math.abs(root.val - ma));
	    out = Math.max(out, Math.abs(root.val - mi));

	    ma = Math.max(ma, root.val);
	    mi = Math.min(mi, root.val);

	    helper(root.left, ma, mi);
	    helper(root.right, ma, mi);
	}

	public static void main(String[] args) {

		String input = ",1,null,2,null,0,3,";

		System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff3(TreeUtils.stringToTreeNode(input)));
	}
}
