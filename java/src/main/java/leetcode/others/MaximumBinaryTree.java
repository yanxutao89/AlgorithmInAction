package leetcode.others;


/*Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.*/

import leetcode.beans.TreeNode;
import leetcode.utils.TreeUtils;

public class MaximumBinaryTree {

	/*
	 * Runtime: 5 ms, faster than 19.76% of Java online submissions for Maximum Binary Tree.
	 * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Maximum Binary Tree.
	 */
	 public static TreeNode constructMaximumBinaryTree(int[] nums) {

		 return lowerUpperBound(nums, 0, nums.length - 1);

	 }

    // using UPPER and LOWER bound to recover the tree
    public static TreeNode lowerUpperBound(int[] nums, int begin, int end) {

    	int index = findMaxValueIndex(nums, begin, end);

    	if (index == -1) {
    		return null;
        }

        TreeNode root = new TreeNode(nums[index]);

        int[] left = getLeftPart(nums, index);
        int[] right = getRightPart(nums, index);

    	root.left = lowerUpperBound(left, 0, left.length - 1);
    	root.right = lowerUpperBound(right, 0, right.length - 1);

        return root;
    }

    private static int[]  getLeftPart(int[] nums, int index) {

    	int[] res = new int[index];

    	for(int i = 0; i < index; i++) {

    		res[i] = nums[i];
    	}

    	return res;

    }

    private static int[]  getRightPart(int[] nums, int index) {

    	int[] res = new int[nums.length - 1 - index];

    	for(int i = 0; i < nums.length - 1 - index; i++) {

    		res[i] = nums[i + index + 1];
    	}

    	return res;

    }
	 private static int findMaxValueIndex(int[] nums, int begin, int end) {

		 int max = Integer.MIN_VALUE;
		 int index = -1;
		 for(int i = begin; i <= end; i++) {

			 if(nums[i] > max) {

				 max = nums[i];
				 index = i;
			 }
		 }

		 return index;
	 }

	/*
	 * Runtime: 2 ms, faster than 99.68% of Java online submissions for Maximum Binary Tree.
	 * Memory Usage: 38.5 MB, less than 91.30% of Java online submissions for Maximum Binary Tree.
	 */
	 public static TreeNode constructMaximumBinaryTree2(int[] nums) {

		 return lowerUpperBound2(nums, 0, nums.length - 1);

	 }

	 private static TreeNode lowerUpperBound2(int[] nums, int begin, int end){

		 int index = findMaxValueIndex(nums, begin, end);
		 if(index == -1) {

			 return null;
		 }

        TreeNode root = new TreeNode(nums[index]);

        root.left = lowerUpperBound2(nums, begin, index - 1);
        root.right = lowerUpperBound2(nums, index + 1, end);

        return root;
	}

    public static void main(String[] args) {

    	int[] nums = {3,2,1,6,0,5};


    	System.out.println(TreeUtils.treeNodeToString(constructMaximumBinaryTree2(nums)));
    }
}
