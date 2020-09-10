package trees;

import beans.TreeNode;
import utils.TreeUtils;

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

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		List list = new ArrayList();
		if (null == root) {
			return list.toString();
		}
		int depth = getDepth(root, 0);
		preOrder(root, list, 0, depth);
		System.out.println(depth);
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

		list.add(root == null ? null : root.val);
		preOrder(root == null ? null : root.left, list, curr + 1, depth);
		preOrder(root == null ? null : root.right, list, curr + 1, depth);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		TreeNode root = new TreeNode();
		data = data.substring(1, data.length() - 1);
		List<String> list = Arrays.asList(data.split(","));
		generateTreeFromPreOrder(root, list, list.size(), 0, list.size()  - 1);
		return root;
	}

	private TreeNode generateTreeFromPreOrder(TreeNode root, List list, int currSize, int start, int end){
		if (start >= end) {
			return null;
		}
		String valStr = ((String) list.get(start)).trim();
		if ("null".equals(valStr)) {
			return null;
		}
		root.val = Integer.parseInt(valStr);
		currSize = (currSize - 1) >> 1;
		root.left = generateTreeFromPreOrder(root, list, currSize,start  + 1, end - currSize);
		root.right = generateTreeFromPreOrder(root, list, currSize, start  + currSize + 1, end);

		return root;
	}

	public static void main(String[] args) {

		SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
//		String input = ",1,2,3,null,null,4,5,";
//		TreeNode root = TreeUtils.stringToTreeNode(input);
//		System.out.println(codec.serialize(root));
		String test = "[1, 2, null, null, null, null, null, null, 3, 4, null, null, 5, null, null]";
		System.out.println(codec.serialize(codec.deserialize(test)));
//		System.out.println(codec.deserialize(codec.serialize(root)));
	}
}
