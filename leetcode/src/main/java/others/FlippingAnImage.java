package others;

import java.util.Arrays;

/*Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].*/

public class FlippingAnImage {



	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
	 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Flipping an Image.
	 */
	public static int[][] flipAndInvertImage(int[][] A) {

		 int[][] res = new int[A.length][A[0].length];

		 for(int i = 0; i < A[0].length; i++) {

			 for(int j = A[i].length - 1; j > -1; j--) {

				 res[i][A[i].length - 1 - j] = A[i][j] == 0 ? 1 : 0;
			 }
		 }

		 return res;
	 }


	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
	 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Flipping an Image.
	 */
	public static int[][] flipAndInvertImage2(int[][] A) {

		 int[][] res = new int[A.length][A[0].length];

		 flipAndInvert(res, A);

		 return res;
	 }

	private static void flipAndInvert(int[][] res, int[][] A) {

		int row = 0;
		while(row < A[0].length) {

			int i = 0, j = A[row].length;
			while(i < j) {

				res[row][i] = A[row][A[row].length - 1 - i] == 0 ? 1 : 0;
				res[row][A[row].length - 1 - i] = A[row][i] == 0 ? 1 : 0;
				i++;
				j--;
			}

			row++;
		}
	}


	 public static void main(String[] args) {

		 int[][] A = {{1,1,0},{1,0,1},{0,0,0}};

		 System.out.println(Arrays.deepToString(flipAndInvertImage2(A)));
	 }
}
