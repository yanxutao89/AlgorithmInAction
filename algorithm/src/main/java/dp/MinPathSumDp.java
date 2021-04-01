package dp;

/**
 * 给定一个，包含非负整数的 m x n 网格。请找出一条，从左上角到右下角的路径。使得路径上，所有数字总和为最小，每次只能向下，或者向右移动一步。
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 14:15
 */
public class MinPathSumDp implements Dp {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] sum = new int[m][n];
		int i, j;
		sum[0][0] = grid[0][0];

		for (i = 1; i < m; ++i) {
			sum[i][0] = sum[i - 1][0] + grid[i][0];
		}

		for (j = 1; j < n; ++j) {
			sum[0][j] = sum[0][j - 1] + grid[0][j];
		}

		for (i = 1; i < m; ++i) {
			for (j = 1; j < n; ++j) {
				sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
			}
		}

		return sum[i - 1][j - 1];
	}

}
