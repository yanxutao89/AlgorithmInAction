package leetcode.trees;


import leetcode.beans.QuadTreeNode;

/**
 * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
 *
 * Return the root of the Quad-Tree representing the grid.
 *
 * Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the answer.
 *
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
 *
 * val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
 * isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
 * class Node {
 *     public boolean val;
 *     public boolean isLeaf;
 *     public Node topLeft;
 *     public Node topRight;
 *     public Node bottomLeft;
 *     public Node bottomRight;
 * }
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 *
 * If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
 * If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
 * Recurse for each of the children with the proper sub-grid.
 *
 * If you want to know more about the Quad-Tree, you can refer to the wiki.
 *
 * Quad-Tree format:
 *
 * The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies a path terminator where no node exists below.
 *
 * It is very similar to the serialization of the binary tree. The only difference is that the node is represented as a list [isLeaf, val].
 *
 * If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf or val is False we represent it as 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
 * Explanation: The explanation of this example is shown below:
 * Notice that 0 represnts False and 1 represents True in the photo representing the Quad-Tree.
 *
 * Example 2:
 *
 *
 *
 * Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
 * Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
 * Explanation: All values in the grid are not the same. We divide the grid into four sub-grids.
 * The topLeft, bottomLeft and bottomRight each has the same value.
 * The topRight have different values so we divide it into 4 sub-grids where each has the same value.
 * Explanation is shown in the photo below:
 *
 * Example 3:
 *
 * Input: grid = [[1,1],[1,1]]
 * Output: [[1,1]]
 * Example 4:
 *
 * Input: grid = [[0]]
 * Output: [[1,0]]
 * Example 5:
 *
 * Input: grid = [[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]
 * Output: [[0,1],[1,1],[1,0],[1,0],[1,1]]
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * n == 2^x where 0 <= x <= 6
 */
public class ConstructQuadTree {

	/*
	 * Runtime: 1 ms, faster than 99.62% of Java online submissions for Construct Quad Tree.
	 * Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Construct Quad Tree.
	 */
	public QuadTreeNode construct(int[][] grid) {
		return constructQuad(grid, 0, grid.length-1, 0, grid[0].length-1);
    }

    public QuadTreeNode constructQuad(int[][] grid, int rB, int rE, int cB, int cE) {

    	if(rB == rE) {
    		return new QuadTreeNode(grid[rB][cB] == 1 ? true : false, true, null, null, null, null);
    	}
        int rowMid = (rB + rE)/2;
        int colMid = (cB + cE)/2;
        QuadTreeNode topLeft = constructQuad(grid, rB, rowMid, cB, colMid);
        QuadTreeNode topRight = constructQuad(grid, rB, rowMid, colMid+1, cE);
        QuadTreeNode bottomLeft = constructQuad(grid, rowMid+1, rE, cB, colMid);
        QuadTreeNode bottomRight = constructQuad(grid, rowMid+1, rE, colMid+1, cE);

        if(isSame(topLeft,topRight,bottomLeft,bottomRight)) {
            return new QuadTreeNode(topLeft.val, true, null, null, null, null);
        }

        return new QuadTreeNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isSame(QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight){
        boolean isSameVal = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;
        if(!isSameVal) {
        	return false;
        }
        return  topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
    }

	public static void main(String[] args) {

		int[][] grid = {{}};
	}
}
