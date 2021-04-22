package utils;

import java.util.LinkedList;
import java.util.Queue;

import beans.TreeNode;

public class TreeUtils {

	public static TreeNode generateBinarySearchTree2GreaterSumTree() {
		TreeNode treeNode = new TreeNode(4);

		// depth of 1
		treeNode.setLeft(new TreeNode(1));
		treeNode.setRight(new TreeNode(6));

		// depth of 2
		treeNode.getLeft().setLeft(new TreeNode(0));
		treeNode.getLeft().setRight(new TreeNode(2));

		treeNode.getRight().setLeft(new TreeNode(5));
		treeNode.getRight().setRight(new TreeNode(7));

		// depth of 3
		treeNode.getLeft().getLeft().setLeft(new TreeNode(null));
		treeNode.getLeft().getLeft().setRight(new TreeNode(null));

		treeNode.getLeft().getRight().setLeft(new TreeNode(null));
		treeNode.getLeft().getRight().setRight(new TreeNode(3));

		treeNode.getRight().getLeft().setLeft(new TreeNode(null));
		treeNode.getRight().getLeft().setRight(new TreeNode(null));

		treeNode.getRight().getRight().setLeft(new TreeNode(null));
		treeNode.getRight().getRight().setRight(new TreeNode(8));

		return treeNode;
	}

	public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.setLeft(new TreeNode(leftNumber));
                nodeQueue.add(node.getLeft());
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.setRight(new TreeNode(rightNumber));
                nodeQueue.add(node.getRight());
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
              output += "null, ";
              continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.getLeft());
            nodeQueue.add(node.getRight());
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

}
