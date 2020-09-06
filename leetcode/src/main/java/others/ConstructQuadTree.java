package others;

import bean.QuadTreeNode;

/*We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.

Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:

Given the 8 x 8 grid below, we want to construct the corresponding quad tree:



It can be divided according to the definition above:





The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.

For the non-leaf nodes, val can be arbitrary, so it is represented as *.



Note:

N is less than 1000 and guaranteened to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.*/
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
