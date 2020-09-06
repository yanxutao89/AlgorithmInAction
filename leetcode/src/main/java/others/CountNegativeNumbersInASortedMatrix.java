package others;

/**
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.

Return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 * @author Administrator
 *
 */
public class CountNegativeNumbersInASortedMatrix {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	 * Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	 * @param grid
	 * @return
	 */
    public int countNegatives(int[][] grid) {

    	int count = 0;
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[i].length; j++) {
    			if (grid[i][j] < 0) {
    				count += grid[i].length - j;
    				break;
    			}
    		}
    	}

    	return count;
    }

    public static void main(String[] args) {

    	int[][] grid = {{-1}};
    	System.out.println(new CountNegativeNumbersInASortedMatrix().countNegatives(grid));
	}
}
