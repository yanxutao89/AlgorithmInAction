package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.

Now, we walk in a clockwise spiral shape to visit every position in this grid.

Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.)

Eventually, we reach all R * C spaces of the grid.

Return a list of coordinates representing the positions of the grid in the order they were visited.



Example 1:

Input: R = 1, C = 4, r0 = 0, c0 = 0
Output: [[0,0],[0,1],[0,2],[0,3]]




Example 2:

Input: R = 5, C = 6, r0 = 1, c0 = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]




Note:

1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C*/
public class SpiralMatrixIII {

	/*
	 * Runtime: 4 ms, faster than 61.93% of Java online submissions for Spiral Matrix III.
	 * Memory Usage: 38.7 MB, less than 12.50% of Java online submissions for Spiral Matrix III.
	 */
	 public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {

		 int[] dx = new int[]{0, 1, 0, -1};
         int[] dy = new int[]{1, 0, -1, 0};
         List<int[]> list = new ArrayList<>();
         int curDirection = 0;
         list.add(new int[]{r0, c0});
         int len = 0;
         while (list.size() < R * C) {
             if (curDirection == 0 || curDirection == 2) len++;
             for (int i = 0; i < len; i++) {
                 r0 += dx[curDirection];
                 c0 += dy[curDirection];
                 if (r0 < 0 || r0 >= R || c0 < 0 || c0 >= C) continue;
                 list.add(new int[]{r0, c0});
             }
             curDirection = (curDirection + 1) % 4;
         }
         int[][] res = new int[list.size()][2];
         for (int i = 0; i < res.length; i++) {
             res[i] = list.get(i);
         }
         return res;
	 }

	 public static void main(String[] args) {

		 int R = 0, C = 0, r0 = 0, c0 = 0;
		 System.out.println(Arrays.toString(new SpiralMatrixIII().spiralMatrixIII(R, C, r0, c0)));
	 }
}
