package others;

import java.util.Arrays;

/*Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.*/
public class SquaresOfASortedArray {

	/*
	 * Runtime: 3 ms, faster than 30.27% of Java online submissions for Squares of a Sorted Array.
	 * Memory Usage: 40.5 MB, less than 96.34% of Java online submissions for Squares of a Sorted Array.
	 */
	public static int[] sortedSquares(int[] A) {

		int[] res = new int[A.length];

		for(int i = 0; i < A.length; i++) {

			res[i] = A[i] * A[i];
		}

		Arrays.sort(res);

		return res;
    }

	public static void main(String[] args) {

		int[] A = {-4,-1,0,3,10};

		System.out.println(Arrays.toString(sortedSquares(A)));
	}
}
