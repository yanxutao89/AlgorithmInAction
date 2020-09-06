package others;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;;

/*A full binary tree is a binary tree where each node has exactly 0 or 2 children.
Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
Each node of each tree in the answer must have node.val = 0.
You may return the final list of trees in any order.

Example 1:
Input: 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]*/
public class AllPossibleBinaryTrees {

	/*
	 * Runtime: 2 ms, faster than 94.67% of Java online submissions for All Possible Full Binary Trees.
	 * Memory Usage: 43.4 MB, less than 100.00% of Java online submissions for All Possible Full Binary Trees.
	 */
	private static Map<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();

	public static List<TreeNode> allPossibleFBT(int N) {

		if (map.containsKey(N)) return map.get(N);

	    List<TreeNode> nodes = new ArrayList<TreeNode>();
	    if (N == 1) {

	    	nodes.add(new TreeNode(0));
	    } else if (N % 2 != 0) {
	        for (int i = 1; i < N; i += 2) {

	        	List<TreeNode> l = allPossibleFBT(i);
	            List<TreeNode> r = allPossibleFBT(N - 1 - i);
	            for (TreeNode lNode : l) {
	                for (TreeNode rNode : r) {

	                	TreeNode root = new TreeNode(0);
	                    root.left = lNode;
	                    root.right = rNode;
	                    nodes.add(root);
	                }
	            }
	        }
	    }

	    map.put(N, nodes);
	    return nodes;
    }

	public static void main(String[] args) {

		int N = 7;

		System.out.println(allPossibleFBT(N));
	}
}
