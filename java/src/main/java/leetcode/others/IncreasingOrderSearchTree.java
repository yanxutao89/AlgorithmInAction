package leetcode.others;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

/*Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.*/
public class IncreasingOrderSearchTree {

	/*
	 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
	 * Memory Usage: 44.4 MB, less than 40.63% of Java online submissions for Increasing Order Search Tree.
	 */
	TreeNode result;
    TreeNode tail;

    public TreeNode increasingBST(TreeNode root) {

    	result = tail = null;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {

    	if (root == null) {
            return;
        }

        dfs(root.left);

        TreeNode node = new TreeNode(root.val);
        if (result == null) {

        	result = node;
            tail = result;
        } else {

        	tail.right = node;
            tail = tail.right;
        }

        dfs(root.right);
    }

	public static void main(String[] args) {

		String input = ",5,3,6,2,4,null,8,1,null,null,null,7,9,";

		System.out.println(TreeUtils.treeNodeToString(new IncreasingOrderSearchTree().increasingBST(TreeUtils.stringToTreeNode(input))));
	}
}
