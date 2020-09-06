package others;

import java.util.Arrays;

/*Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]


Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9*/
public class DuplicateZeros {

	/*
	 * Runtime: 8 ms, faster than 29.67% of Java online submissions for Duplicate Zeros.
	 * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Duplicate Zeros.
	 */
	 public void duplicateZeros(int[] arr) {

		 for(int i = 0; i < arr.length - 1; i++) {

			 if(arr[i] == 0) {

				 for(int j = arr.length - 1; j > i; j--) {

					 arr[j] = arr[j - 1];
				 }
				 arr[i + 1] = 0;
				 i = i + 1;
			 }
		 }

		 System.out.println(Arrays.toString(arr));
	 }

	 public static void main(String[] args) {

		 int[] arr = {1,0,2,3,0,4,5,0};

		 new DuplicateZeros().duplicateZeros(arr);
	 }
}
