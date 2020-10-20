package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import beans.TreeNode;
import utils.TreeUtils;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
	 * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();

		recursive(root, list);

		return list;
    }

	private void recursive(TreeNode root, List<Integer> list) {
		if(root == null) {
			return;
		}
		recursive(root.left, list);
		list.add(root.val);
		recursive(root.right, list);
	}

	/*
	 * Runtime: 1 ms, faster than 57.63% of Java online submissions for Binary Tree Inorder Traversal.
	 * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {

		if(root == null){
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while(!stack.isEmpty() || current != null){

            if(current != null){
            	stack.add(current);
                current = current.left;
            } else {
                TreeNode removedNode = stack.pop();
                result.add(removedNode.val);
                current = removedNode.right;
            }
        }

        return result;
    }

	public List<Integer> preorderTraversal2(TreeNode root) {

		if(root == null){
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while(!stack.isEmpty() || current != null){

            if(current != null){
                stack.push(current);
                result.add(current.val);
                current = current.left;
            } else {
                TreeNode removedNode = stack.pop();
                current = removedNode.right;
            }
        }

        return result;
    }

	public List<Integer> postorderTraversal2(TreeNode root) {

		if(root == null){
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> output = new Stack<TreeNode>();

        TreeNode current = root;
        while(!stack.isEmpty() || current != null){

            if(current!=null){
                stack.push(current);
                output.push(current);
                current = current.right;
            } else {
                current = stack.pop();
                current = current.left;
            }
        }

        while(output.size() > 0) {
        	TreeNode node = output.pop();
        	result.add(node.val);
        }

        return result;
    }

	public static void main(String[] args) {

		String input = ",1,2,3,4,5,6,7,";
		System.out.println(new BinaryTreeInorderTraversal().inorderTraversal2(TreeUtils.stringToTreeNode(input)));
		System.out.println(new BinaryTreeInorderTraversal().preorderTraversal2(TreeUtils.stringToTreeNode(input)));
		System.out.println(new BinaryTreeInorderTraversal().postorderTraversal2(TreeUtils.stringToTreeNode(input)));
	}
}
