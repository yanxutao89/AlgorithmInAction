package others;

import java.util.ArrayList;
import java.util.List;

/*We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.



Example 1:

Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39


Note:

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] is 0 or 1.*/
public class ScoreAfterFlippingMatrix {

	/*
	 * Runtime: 1 ms, faster than 37.69% of Java online submissions for Score After Flipping Matrix.
	 * Memory Usage: 38.5 MB, less than 60.00% of Java online submissions for Score After Flipping Matrix.
	 */
	public int matrixScore(int[][] A) {

		for(int i = 0; i < A.length; i++) {

		   if(A[i][0] == 0) {

			   flipRow(A, i);
		   }
		}

		for(int i = 1; i < A[0].length; i++) {

			int zeros = 0, ones = 0;
			for(int j = 0; j < A.length; j++) {

				if(A[j][i] == 0) {
					zeros++;
			    }

			    if(A[j][i] == 1) {
			    	ones++;
			    }
			}

		   if(zeros > ones) {
			   flipCol(A, i);
		   }
		}

		return getScore(A);
	}

	private static void flipRow(int[][] A, int row) {

		for(int i = 0; i < A[row].length; i++) {

			A[row][i] = A[row][i] == 0 ? 1 : 0;
		}
	}

	private static void flipCol(int[][] A, int col) {

		for(int i = 0; i < A.length; i++) {

			A[i][col] = A[i][col] == 0 ? 1 : 0;
		}
	}

	private static int getScore(int[][] A) {

		int sum = 0;

		for(int i = 0; i < A.length; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < A[0].length; j++) {

				sb.append(A[i][j]);
			}

			sum += Integer.parseInt(sb.toString(), 2);
		}

		return sum;
	}

	public static void main(String[] args) {

		int[][] A = {{0,0,1,1},
					{1,0,1,0},
					{1,1,0,0}};
		System.out.println(new ScoreAfterFlippingMatrix().matrixScore(A));
	}

}
