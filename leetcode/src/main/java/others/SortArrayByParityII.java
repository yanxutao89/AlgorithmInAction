package others;

import java.util.Arrays;

/*Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.



Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


Note:

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000*/
public class SortArrayByParityII {

	/*
	 * Runtime: 2 ms, faster than 99.65% of Java online submissions for Sort Array By Parity II.
	 * Memory Usage: 41.4 MB, less than 92.59% of Java online submissions for Sort Array By Parity II.
	 */
	public int[] sortArrayByParityII(int[] A) {

		int[] res = new int[A.length];
        int even = 0, odd = 1;

		for(int i : A) {

			if(i % 2 == 0) {

				res[even] = i;
				even += 2;
			} else {

				res[odd] = i;
				odd += 2;
			}
		}

        return res;
	}

	public static void main(String[] args) {

		int[] A = {4,2,5,7};

		System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(A)));
	}
}
