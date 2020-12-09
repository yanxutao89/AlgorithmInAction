package others;

/*Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.



Note:

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100*/
public class MinimumFallingPathSum {

	/*
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Falling Path Sum.
	 * Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Minimum Falling Path Sum.
	 */
	public int minFallingPathSum(int[][] A){

		if(A == null || A.length == 0){
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int[][] memo = new int[A.length][A[0].length];
        boolean[][] flag = new boolean[A.length][A[0].length];

        for(int i = 0; i < A[0].length; i++){
            result = Math.min(dfs(A, 0, i, memo, flag), result);
        }

        return result;
    }

    private int dfs(int[][] A, int row, int col, int[][] memo, boolean[][] flag){

    	if(flag[row][col]){
            return memo[row][col];
        }

    	int currentPathSum = A[row][col];
        if(row + 1 < A.length){

        	int verticalFalling = currentPathSum + dfs(A, row + 1, col, memo, flag);
            int leftFalling = Integer.MAX_VALUE;
            if(col + 1 < A[row].length){
                leftFalling = currentPathSum + dfs(A, row + 1, col + 1, memo, flag);
            }

            int rightFalling = Integer.MAX_VALUE;
            if(col - 1 >= 0){
                rightFalling = currentPathSum + dfs(A, row + 1, col - 1, memo, flag);
            }

            int result = Math.min(Math.min(verticalFalling, leftFalling), rightFalling);

            memo[row][col] = result;
            flag[row][col] = true;

            return result;
        }

        memo[row][col] = currentPathSum;
        flag[row][col] = true;

        return currentPathSum;
    }

	 public static void main(String[] args) {

		 int[][] A = {{1,2,3},{4,5,6},{7,8,9}};

		 System.out.println(new MinimumFallingPathSum().minFallingPathSum(A));
	 }
}
