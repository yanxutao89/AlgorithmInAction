package others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.

Return the maximum number of rows that have all values equal after some number of flips.



Example 1:

Input: [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.


Note:

1 <= matrix.length <= 300
1 <= matrix[i].length <= 300
All matrix[i].length's are equal
matrix[i][j] is 0 or 1*/
public class FlipColumnsForMaximumNumberOfEqualRows {

	/*
	 * Runtime: 31 ms, faster than 75.07% of Java online submissions for Flip Columns For Maximum Number of Equal Rows.
	 * Memory Usage: 60.8 MB, less than 100.00% of Java online submissions for Flip Columns For Maximum Number of Equal Rows.
	 */
	public int maxEqualRowsAfterFlips(int[][] matrix) {

		Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] row : matrix) {
            StringBuilder toZero = new StringBuilder();
            StringBuilder toOnes = new StringBuilder();
            for (int col : row) {
                if (col == 1) {
                    toZero.append(1);
                    toOnes.append(0);
                } else {
                    toZero.append(0);
                    toOnes.append(1);
                }
            }
            String to0s = toZero.toString();
            String to1s = toOnes.toString();
            map.put(to0s, map.getOrDefault(to0s, 0) + 1);
            map.put(to1s, map.getOrDefault(to1s, 0) + 1);
            max = Math.max(max, Math.max(map.get(to0s), map.get(to1s)));
        }
        return max;
    }

	public static void main(String[] args) {

		int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};

		System.out.println(new FlipColumnsForMaximumNumberOfEqualRows().maxEqualRowsAfterFlips(matrix));
	}
}
