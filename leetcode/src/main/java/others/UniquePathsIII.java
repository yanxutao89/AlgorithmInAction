package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation:
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.


Note:

1 <= grid.length * grid[0].length <= 20*/
public class UniquePathsIII {


	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths III.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Unique Paths III.
	 */
	int result = 0;
    int countZero = 0;
    int k,l = 0;
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

            	if(grid[i][j]==1){
                    k=i;
                    l=j;
                }

            	if(grid[i][j]==0){
                    countZero++;
                }
            }
        }

        grid[k][l]=0;
        uniquePaths(grid,k,l,-1);

        return result;
    }

	public void uniquePaths(int[][] grid, int i, int j, int counter) {

        if(i<0 || i==grid.length || j<0 || j==grid[0].length){
            return;
        }

        if(grid[i][j]==-1||grid[i][j]==3){
            return;
        } else if(grid[i][j]==2){
            if(counter == countZero) {

            	result++;
            }
            return;
        }
		// When we visit an element of the grid, we set that to 3, so we'll know that we visited that element
        if(grid[i][j]==0){

            grid[i][j]=3;
            uniquePaths(grid, i+1, j, counter+1);
            uniquePaths(grid, i-1, j, counter+1);
            uniquePaths(grid, i, j+1, counter+1);
            uniquePaths(grid, i, j-1, counter+1);
            grid[i][j]=0;
        }
    }

	public static void main(String[] args) {

		UniquePathsIII uniquePathsIII = new  UniquePathsIII();
		int[][] grid = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};

		System.out.println(uniquePathsIII.uniquePathsIII(grid));
	}
}
