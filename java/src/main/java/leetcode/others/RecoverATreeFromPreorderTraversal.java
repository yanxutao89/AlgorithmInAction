package leetcode.others;

import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/*We run a preorder depth first search on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)

If a node has only one child, that child is guaranteed to be the left child.

Given the output S of this traversal, recover the tree and return its root.



Example 1:



Input: "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]
Example 2:



Input: "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]


Example 3:



Input: "1-401--349---90--88"
Output: [1,401,null,349,88,90]


Note:

The number of nodes in the original tree is between 1 and 1000.
Each node will have a value between 1 and 10^9.*/
public class RecoverATreeFromPreorderTraversal {


	/*
	 * Runtime: 18 ms, faster than 9.62% of Java online submissions for Recover a Tree From Preorder Traversal.
	 * Memory Usage: 39.6 MB, less than 36.00% of Java online submissions for Recover a Tree From Preorder Traversal.
	 */
	public TreeNode recoverFromPreorder(String S) {

		TreeNode root = new TreeNode();
		LinkedList<HashMap<Integer, Integer>> list = new LinkedList<HashMap<Integer, Integer>>();

		int count = 0;
		StringBuffer sb = new StringBuffer();

		for(char c : S.toCharArray()) {

			if(c == '-') {
				if(sb.length() > 0) {

					HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
					map.put(count, Integer.parseInt(sb.toString()));
					list.add(map);
					sb = new StringBuffer();
					count = 0;
				}

				count++;
			} else {

				sb.append(c);
			}
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(count, Integer.parseInt(sb.toString()));
		list.add(map);

		return recursiveGenerate(root, list, 0);

    }

	private TreeNode recursiveGenerate(TreeNode root, LinkedList<HashMap<Integer, Integer>> list, int depth) {

		if(list == null || list.size() == 0) {

			return null;
		}

		root = new TreeNode();
		root.val = list.get(0).get(depth);

		root.left = recursiveGenerate(root.left, split(list, depth + 1).get(0), depth + 1);
		root.right = recursiveGenerate(root.right, split(list, depth + 1).get(1), depth + 1);

		if (root.left == null && root.right != null) {

			root.left = root.right;
			root.right = null;
		}

		return root;
	}

	private List<LinkedList<HashMap<Integer, Integer>>> split(LinkedList<HashMap<Integer, Integer>> list, int key) {

		List<LinkedList<HashMap<Integer, Integer>>> arr = new ArrayList<LinkedList<HashMap<Integer,Integer>>>();
		arr.add(0, new LinkedList<HashMap<Integer,Integer>>());
		arr.add(1, new LinkedList<HashMap<Integer,Integer>>());

		LinkedList<HashMap<Integer, Integer>> list2 =  null;
		for(Map<Integer, Integer> map : list) {

			if(map.containsKey(key)) {

				if(list2 == null) {

					list2 = new LinkedList<HashMap<Integer,Integer>>();
				} else {

					arr.add(0, list2);
					list2 = new LinkedList<HashMap<Integer,Integer>>();
				}
			}

			if(list2 != null) {

				list2.add((HashMap<Integer, Integer>) map);
			}
		}

		arr.add(1, list2);

		return arr;
	}

	public static void main(String[] args) {

		String S = "1-401--349---90--88";

		System.out.println(TreeUtils.treeNodeToString(new RecoverATreeFromPreorderTraversal().recoverFromPreorder(S)));
	}
}
