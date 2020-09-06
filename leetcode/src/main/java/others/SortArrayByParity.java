package others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
*/
public class SortArrayByParity {

	/*
	 * Runtime: 4 ms, faster than 10.48% of Java online submissions for Sort Array By Parity.
	 * Memory Usage: 41.1 MB, less than 84.72% of Java online submissions for Sort Array By Parity.
	 */
	 public static int[] sortArrayByParity(int[] A) {

		 int[] res = new int[A.length];
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		 for(int i = 0; i < A.length; i++) {

			 map.put(i, A[i]);
		 }

		 int begin = 0, end = A.length - 1;
		 for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

			 if(entry.getValue() % 2 == 0) {

				 res[begin++] = entry.getValue();
			 } else {

				 res[end--] = entry.getValue();
			 }
		 }

		 return res;
	 }


	/*
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array By Parity.
	 * Memory Usage: 40.2 MB, less than 93.75% of Java online submissions for Sort Array By Parity.
	 */
	 public static int[] sortArrayByParity2(int[] A) {

		 int[] res = new int[A.length];

		 int begin = 0, end = A.length - 1;
		 for(int num : A) {

			 if(num % 2 == 0) {

				 res[begin++] = num;
			 } else {

				 res[end--] = num;
			 }
		 }

		 return res;
	 }

	 public static void main(String[] args) {

		 int[] A = {3,1,2,4};

		 System.out.println(Arrays.toString(sortArrayByParity(A)));
	 }
}
