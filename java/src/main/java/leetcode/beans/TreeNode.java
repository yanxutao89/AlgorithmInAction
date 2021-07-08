package leetcode.beans;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {

	}

	public TreeNode(Integer val) {
		this.setVal(val == null ? null : val);
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return this.left;
	}

	public TreeNode getRight() {
		return this.right;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public String toString() {

		return this.val + "";
	}
}
