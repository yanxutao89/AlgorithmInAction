package others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.
Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5

Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even
*/
public class NRepeatedElementInSize2NArray {

	/*
	 * Runtime: 27 ms, faster than 5.38% of Java online submissions for N-Repeated Element in Size 2N Array.
	 * Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
	 */
	 public static int repeatedNTimes(int[] A) {

		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int num : A) {

			 Integer value = map.get(num);

			 map.put(num, value == null ? 1 : value + 1);

			 if(map.get(num) != null && map.get(num) == A.length / 2) {

				 return num;
			 }
		 }

		 return 0;
	 }


	/*
	 * Runtime: 18 ms, faster than 26.84% of Java online submissions for N-Repeated Element in Size 2N Array.
	 * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
	 */
	 public static int repeatedNTimes2(int[] A) {

		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int num : A) {

			 Integer value = map.get(num);

			 map.put(num, value == null ? 1 : ++value);

			 if(value != null && value == A.length / 2) {

				 return num;
			 }
		 }

		 return 0;
	 }

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
	 * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
	 */
	 public static int repeatedNTimes3(int[] A) {

		 if(A.length == 0) {

             return 0;
		 }

         for (int i = 1;i < A.length; i++){

             if(A[i] == A[i-1]) {

            	 return A[i];
             } else if(i - 2 >= 0 && A[i] == A[i-2]) {

            	 return A[i];
             } else if(i-3 >= 0 && A[i] == A[i-3]) {

            	 return A[i];
             }
         }

        return -1;
	 }

	 public static void main(String[] args) {

		 int[] A = {1,2,3,3};

		 System.out.println(repeatedNTimes3(A));
	 }

}
