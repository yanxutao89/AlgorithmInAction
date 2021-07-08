package leetcode.trees;


import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

import java.util.*;

/**
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/09/09 14:22
 */
public class SerializeAndDeserializeBinaryTree {

	/**
	 * 47 / 48 test cases passed.
	 * Status: Memory Limit Exceeded
	 * @param root
	 * @return
	 */
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		List<Integer> list = new ArrayList();
		if (null == root) {
			return list.toString();
		}
		int depth = getDepth(root, 0);
		preOrder(root, list, 0, depth);
		return list.toString();
	}

	private int getDepth(TreeNode root, int depth) {
		if (root == null) {
			return depth;
		}
		depth++;
		return Math.max(getDepth(root.left, depth), getDepth(root.right, depth));
	}

	private void preOrder(TreeNode root, List list, int curr, int depth) {
		if (curr > depth) {
			return;
		}

		list.add(root == null ? "null" : root.val);
		preOrder(root == null ? null : root.left, list, curr + 1, depth);
		preOrder(root == null ? null : root.right, list, curr + 1, depth);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		data = data.substring(1, data.length() - 1);
		List<String> list = Arrays.asList(data.split(","));
		return generateTreeFromPreOrder(list.size(), 0, list.size()  - 1, list);
	}

	private TreeNode generateTreeFromPreOrder(int currSize, int start, int end, List list){

		if (start >= end) {
			return null;
		}

		String valStr = ((String) list.get(start)).trim();
		if ("null".equals(valStr)) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(valStr));
		currSize = (currSize - 1) >> 1;
		root.left = generateTreeFromPreOrder(currSize,start  + 1, end - currSize, list);
		root.right = generateTreeFromPreOrder(currSize, start  + currSize + 1, end, list);

		return root;
	}

	/**
	 * Runtime: 16 ms, faster than 53.06% of Java online submissions for Serialize and Deserialize Binary Tree.
	 * Memory Usage: 41.2 MB, less than 81.49% of Java online submissions for Serialize and Deserialize Binary Tree.
	 * @param root
	 * @return
	 */
	// Encodes a tree to a single string.
	public String serialize2(TreeNode root) {
		if(root == null)
			return "()";
		return "(" + root.val + serialize2(root.left) + serialize2(root.right) + ")";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize2(String data) {

		int left = data.indexOf('(');
		int right = data.lastIndexOf(')');

		if(right - left == 1) {
			return null;
		}

		int left2 = data.indexOf('(',left + 1);
		int val = Integer.parseInt(data.substring(left + 1, left2));
		int right2 = -1;
		int level = 0;
		for(int i = 0 ; i < data.length() ; ++i) {
			char c = data.charAt(i);
			if(c == '(') {
				level++;
			} else if(c == ')') {
				level--;
			} else {
				continue;
			}
			if(c == ')' && level == 1) {
				right2 = i;
				break;
			}
		}

		TreeNode root = new TreeNode(val);
		root.left = deserialize2(data.substring(left2, right2 + 1));
		root.right = deserialize2(data.substring(right2 + 1, right));

		return root;
	}

	public static void main(String[] args) {

		SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
		String input = "[1,2,3,null,null,4,5]";
		TreeNode root = TreeUtils.stringToTreeNode(input);
		System.out.println(codec.serialize2(root));
		TreeNode node = codec.deserialize2(codec.serialize2(root));
		System.out.println(codec.serialize2(node));
	}
}
