package others;
/**
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
 * We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings).
 * Height 0 is considered to be a building as well.
 * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right,
 * must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings
 * when viewed from a distance. See the following example. What is the maximum total sum that the height of the buildings can be increased?
 *
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation:
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 *
 * The skyline viewed from top or bottom is: [9, 4, 8, 7]
 * The skyline viewed from left or right is: [8, 7, 9, 3]
 *
 * The grid after increasing the height of buildings without affecting skylines is:
 * gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]
 *
 * @author Dell
 *
 */
public class MaxIncrease2KeepCitySkyline {

	/**
	 * Runtime: 5 ms, faster than 8.71% of Java online submissions for Max Increase to Keep City Skyline.
	 * Memory Usage: 44.6 MB, less than 6.25% of Java online submissions for Max Increase to Keep City Skyline.
	 * @param grid
	 * @return
	 */
	public static int maxIncreaseKeepingSkyline(int[][] grid) {

		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			int rowSkyline = findMax(grid[i]);

			for(int j = 0; j < grid[i].length; j++) {
				int colSkyline = findMax(extractColumn(grid, j));

				int minValue = Math.min(rowSkyline, colSkyline);

				res += minValue - grid[i][j];
			}
		}

		return res;

	}

	private static int findMax(int[] elements) {

		int res = elements[0];
		for(int i = 0; i < elements.length; i++) {

			if(elements[i] > res || elements[i] == res) {

				res = elements[i];
			}
		}

		return res;
	}

	private static int[] extractColumn(int[][] grid, int columnIndex) {

		int res[] = new int[grid[0].length];

		for(int i = 0; i < grid[0].length; i++) {

			res[i] = grid[i][columnIndex];
		}

		return res;
	}

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Increase to Keep City Skyline.
	 * Memory Usage: 40.5 MB, less than 96.25% of Java online submissions for Max Increase to Keep City Skyline.
	 * @param grid
	 * @return
	 */
	public static int maxIncreaseKeepingSkyline2(int[][] grid) {

		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			int rowSkyline = findMax(grid, i, "row");

			for(int j = 0; j < grid[i].length; j++) {
				int colSkyline = findMax(grid, j, "column");

				int minValue = Math.min(rowSkyline, colSkyline);

				res += minValue - grid[i][j];
			}
		}

		return res;
	}

	private static int findMax(int[][] grid, int index, String type) {

		int res = 0, len = 0;

		if ("row".equals(type)) {
			len = grid[index].length;
			res = grid[index][0];
			for (int i = 0; i < len; i++) {

				if (grid[index][i] > res) {

					res = grid[index][i];
				}
			}
		}

		if ("column".equals(type)) {
			len = grid.length;
			res = grid[0][index];
			for (int i = 0; i < len; i++) {

				if (grid[i][index] > res) {

					res = grid[i][index];
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {

		int[][] grid = { {3, 0, 8, 4},
		                 {2, 4, 5, 7},
		                 {9, 2, 6, 3},
		                 {0, 3, 1, 0} };

		System.out.println(maxIncreaseKeepingSkyline2(grid));

	}
}
